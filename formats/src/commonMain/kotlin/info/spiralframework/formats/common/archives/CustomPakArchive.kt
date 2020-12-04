package info.spiralframework.formats.common.archives

import dev.brella.kornea.io.common.DataSource
import dev.brella.kornea.io.common.flow.CountingOutputFlow
import dev.brella.kornea.io.common.flow.OutputFlow
import dev.brella.kornea.io.common.flow.extensions.copyFrom
import dev.brella.kornea.io.common.flow.extensions.writeInt32LE
import dev.brella.kornea.io.common.flow.int
import dev.brella.kornea.io.common.flow.withState
import dev.brella.kornea.io.common.useInputFlow

@ExperimentalUnsignedTypes
class CustomPakArchive {
    private val _files: MutableMap<Int, DataSource<*>> = HashMap()
    val files: List<Map.Entry<Int, DataSource<*>>>
        get() = _files.entries.sortedBy(Map.Entry<Int, DataSource<*>>::key)

    fun add(dataSource: DataSource<*>) = set(nextFreeIndex(), dataSource)
    operator fun set(index: Int, dataSource: DataSource<*>) {
        requireNotNull(dataSource.dataSize)
        //TODO: Automatically cache if not reproducible?
        require(dataSource.reproducibility.isStatic() || dataSource.reproducibility.isDeterministic()) //We want reproducible data only
        _files[index] = dataSource
    }

    suspend fun compile(output: OutputFlow) = compileFrom(output, if (output is CountingOutputFlow) output.streamOffset else 0)
    suspend fun compileFrom(output: OutputFlow, startingOffset: Long) {
        val output = withState { int(output) }

        output.writeInt32LE(_files.size)

        var offset = startingOffset + 4 + (_files.size * 4)

        val range = (_files.keys.maxOrNull() ?: return) + 1

        for (index in 0 until range) {
            val dataSource = _files[index] ?: continue

            output.writeInt32LE(offset)
            offset += dataSource.dataSize!!.toLong()
        }

        for (index in 0 until range) {
            val dataSource = _files[index] ?: continue
            dataSource.useInputFlow { output.copyFrom(it) }
        }
    }

    fun nextFreeIndex(): Int {
        var prev = 0
        _files.keys.forEach { index ->
            if (index > prev + 1)
                return prev + 1
            prev = index
        }

        return _files.size
    }
}

@ExperimentalUnsignedTypes
inline fun pakArchive(block: CustomPakArchive.() -> Unit): CustomPakArchive {
    val pak = CustomPakArchive()
    pak.block()
    return pak
}
@ExperimentalUnsignedTypes
suspend fun OutputFlow.compilePakArchive(block: CustomPakArchive.() -> Unit) {
    val pak = CustomPakArchive()
    pak.block()
    pak.compile(this)
}
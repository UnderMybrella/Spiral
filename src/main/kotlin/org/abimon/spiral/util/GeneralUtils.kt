package org.abimon.spiral.util

import org.abimon.spiral.core.archives.IArchive
import org.abimon.spiral.core.objects.archives.CPK
import org.abimon.spiral.core.objects.archives.CPKFileEntry
import org.abimon.spiral.core.objects.archives.WAD
import org.abimon.spiral.core.utils.CountingInputStream
import org.abimon.spiral.core.utils.WindowedInputStream
import org.abimon.visi.collections.copyFrom
import org.abimon.visi.io.skipBytes
import java.io.File
import java.io.InputStream
import java.io.OutputStream
import kotlin.reflect.KFunction

operator fun SemanticVersion.compareTo(semver: SemanticVersion): Int {
    if (this.first > semver.first)
        return 1
    else if (this.first < semver.first)
        return -1

    if (this.second > semver.second)
        return 1
    else if (this.second < semver.second)
        return -1

    if (this.third > semver.third)
        return 1
    else if (this.third < semver.third)
        return -1

    return 0
}

fun intArrayOfPairs(vararg pairs: Pair<Int, Int>): IntArray {
    val array = IntArray(pairs.size * 2)
    for (i in pairs.indices) {
        val (a, b) = pairs[i]
        array[i * 2] = a
        array[i * 2 + 1] = b
    }

    return array
}

fun Pair(array: IntArray): Pair<Int, Int> = Pair(array[0], array[1])

fun Number.toUnsignedByte(): Int = this.toByte().toInt() and 0xFF

//fun <T> KFunction<T>.bind(vararg params: Pair<String, Any?>): () -> T = { this.call() }

fun <T> KFunction<T>.bind(vararg orderedParams: Any?): () -> T = { this.call(*orderedParams) }

fun CPKFileEntry.rawInputStreamFor(cpk: CPK): InputStream = WindowedInputStream(cpk.dataSource(), this.offset, this.fileSize)

inline fun getLastCaller(stepsDown: Int = 0): String? = Thread.currentThread().stackTrace.copyFrom(1 + stepsDown).firstOrNull { it.className != "org.abimon.spiral.util.LoggerKt" && !it.className.contains('$') }?.toString()

class SeekableInputStream(seekable: InputStream) : CountingInputStream(seekable) {
    fun seek(offset: Long) {
        reset()
        skipBytes(offset)
    }
}

fun InputStream.copyWithProgress(out: OutputStream, bufferSize: Int = DEFAULT_BUFFER_SIZE, progress: ((Long) -> Unit)?): Long {
    var bytesCopied = 0L
    val buffer = ByteArray(bufferSize)
    var bytes = read(buffer)
    while (bytes >= 0) {
        out.write(buffer, 0, bytes)
        bytesCopied += bytes
        progress?.invoke(bytesCopied)
        bytes = read(buffer)
    }
    return bytesCopied
}

fun String.sanitisePath(): String = this.replace("/", File.separator).replace("\\", File.separator)

fun CPK.fileSourceForName(name: String): (() -> InputStream)? {
    val sanitised = name.sanitisePath()

    return files.firstOrNull { entry -> "${entry.directoryName}/${entry.fileName}" == sanitised }?.let { entry -> entry::inputStream }
}

fun WAD.fileSourceForName(name: String): (() -> InputStream)? {
    val sanitised = name.sanitisePath()

    return files.firstOrNull { entry -> entry.name == sanitised }?.let { entry -> entry::inputStream }
}

fun IArchive.fileSourceForname(name: String): (() -> InputStream)? {
    val sanitised = name.sanitisePath()

    return fileEntries.firstOrNull { (entryName) -> entryName == sanitised }?.second
}

val File.absoluteParentFile: File
    get() = File(absolutePath.substringBeforeLast(File.separator))
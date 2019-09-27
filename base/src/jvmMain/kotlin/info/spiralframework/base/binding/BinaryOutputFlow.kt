package info.spiralframework.base.binding

import info.spiralframework.base.common.io.flow.OutputFlow
import info.spiralframework.base.jvm.io.JVMOutputFlow
import java.io.ByteArrayOutputStream

@ExperimentalUnsignedTypes
actual open class BinaryOutputFlow(private val _internal: ByteArrayOutputStream) : OutputFlow by JVMOutputFlow(_internal) {
    actual constructor(): this(ByteArrayOutputStream())
    actual fun getDataSize(): ULong = _internal.size().toULong()
    actual fun getData(): ByteArray = _internal.toByteArray()
}
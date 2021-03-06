package info.spiralframework.formats.archives.srd

import info.spiralframework.base.CountingInputStream
import info.spiralframework.base.WindowedInputStream
import info.spiralframework.base.util.assertAsLocaleArgument
import info.spiralframework.base.util.readInt32BE
import info.spiralframework.base.util.readString
import info.spiralframework.formats.archives.SRD
import info.spiralframework.formats.utils.*
import java.io.InputStream

open class SRDEntry(val dataType: String, val offset: Long, val dataLength: Int, val subdataLength: Int, val srd: SRD) {
    companion object {
        operator fun invoke(stream: CountingInputStream, srd: SRD): SRDEntry {
            val dataType = stream.readString(4)

            val dataLength = stream.readInt32BE()
            val subdataLength = stream.readInt32BE()
            val padding = stream.readInt32BE()

            val offset = stream.streamOffset
            val skip = (dataLength + subdataLength + dataLength.align() + subdataLength.align()).toLong()
            assertAsLocaleArgument(skip >= 0, "formats.srd.invalid_skip", skip, dataLength, subdataLength)
            stream.skip(skip)

            when(dataType) {
                "\$TXI" -> return TXIEntry(dataType, offset, dataLength, subdataLength, srd)
                "\$TXR" -> return TXREntry(dataType, offset, dataLength, subdataLength, srd)
                "\$RSI" -> return RSIEntry(dataType, offset, dataLength, subdataLength, srd)
                "\$VTX" -> return VTXEntry(dataType, offset, dataLength, subdataLength, srd)
                "\$MAT" -> return MATEntry(dataType, offset, dataLength, subdataLength, srd)
                "\$MSH" -> return MSHEntry(dataType, offset, dataLength, subdataLength, srd)
                else -> return SRDEntry(dataType, offset, dataLength, subdataLength, srd)
            }
        }
    }

    val dataStream: InputStream
        get() = WindowedInputStream(srd.dataSource(), offset.toLong(), dataLength.toLong())

    val subdataStream: InputStream
        get() = WindowedInputStream(srd.dataSource(), (offset + dataLength + dataLength.align()), subdataLength.toLong())

    val size: Int = dataLength + subdataLength + dataLength.align() + subdataLength.align()

    open val rsiEntry: RSIEntry? by lazy {
        if (subdataLength > 16)
            return@lazy (subdataStream as WindowedInputStream).use { substream -> SRDEntry(substream, srd) } as? RSIEntry
        return@lazy null
    }
}
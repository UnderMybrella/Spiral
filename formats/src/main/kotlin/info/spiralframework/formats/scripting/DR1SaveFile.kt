package info.spiralframework.formats.scripting

import info.spiralframework.base.util.*
import info.spiralframework.formats.utils.*
import java.io.InputStream

class DR1SaveFile private constructor(val dataSource: DataSource) {
    companion object {
        const val MAGIC_NUMBER      = 0x617461640000000C
        const val BIN_MAGIC_NUMBER  = 0x3AC946E69622E.toInt()
        val FILE_NUMBER_RANGE = 0 .. 30

        fun Int.convertASCIIToInt(): Int {
            val a = ((this shr 0) and 0xFF) % 48
            val b = ((this shr 8) and 0xFF) % 48
            val c = ((this shr 16) and 0xFF) % 48
            val d = ((this shr 24) and 0xFF) % 48

            return (a * 1000) + (b * 100) + (c * 10) + (d * 1)
        }

        operator fun invoke(dataSource: () -> InputStream): DR1SaveFile? {
            try {
                return DR1SaveFile(dataSource)
            } catch (iae: IllegalArgumentException) {
                DataHandler.LOGGER.debug("formats.lin.invalid", dataSource, iae)

                return null
            }
        }

        fun unsafe(dataSource: () -> InputStream): DR1SaveFile = DR1SaveFile(dataSource)

    }

    val size: Int
    val danganronpaString: String
    val chapterSectionString: String
    val debugInfoString: String
    val lastPlayedString: String

    init {
        val stream = dataSource()

        try {
            val magic = stream.readInt64LE()
            assertAsLocaleArgument(magic == MAGIC_NUMBER, "fuck.you")

            val fileNumber = stream.readInt32LE().convertASCIIToInt()
            assertAsLocaleArgument(fileNumber in FILE_NUMBER_RANGE, "fuck.you.range")

            val binMagic = stream.readInt32LE()
            assertAsLocaleArgument(binMagic == BIN_MAGIC_NUMBER, "fuck.you.bin")

            size = stream.readInt32LE()
            danganronpaString = String(stream.readXBytes(64), Charsets.US_ASCII, String.Mode.NULL_TERMINATED)
            chapterSectionString = String(stream.readXBytes(128), Charsets.US_ASCII, String.Mode.NULL_TERMINATED)
            debugInfoString = String(stream.readXBytes(512), Charsets.US_ASCII, String.Mode.NULL_TERMINATED)

            lastPlayedString = String(stream.readXBytes(32), Charsets.US_ASCII, String.Mode.NULL_TERMINATED)

            //D880: coins
        } finally {
            stream.close()
        }
    }
}
package info.spiralframework.core.formats.archives

import dev.brella.kornea.errors.common.KorneaResult
import dev.brella.kornea.errors.common.Optional
import dev.brella.kornea.errors.common.filter
import info.spiralframework.base.common.SpiralContext
import info.spiralframework.core.common.formats.FormatReadContext
import info.spiralframework.core.common.formats.ReadableSpiralFormat
import info.spiralframework.formats.common.archives.srd.SrdArchive
import dev.brella.kornea.io.common.DataSource

object SrdArchiveFormat: ReadableSpiralFormat<SrdArchive> {
    override val name: String = "SRD"
    override val extension: String = "srd"

    override suspend fun identify(context: SpiralContext, readContext: FormatReadContext?, source: DataSource<*>): KorneaResult<Optional<SrdArchive>> {
        val fileName = readContext?.name?.substringAfterLast('/')
        if (fileName != null && fileName.contains('.') && !fileName.substringAfterLast('.').equals(extension, true)) {
            return KorneaResult.errorAsIllegalArgument(-1, "Invalid extension ${fileName.substringAfterLast('.')}")
        }

        return super.identify(context, readContext, source)
    }

    /**
     * Attempts to read the data source as [T]
     *
     * @param name Name of the data, if any
     * @param game Game relevant to this data
     * @param context Context that we retrieved this file in
     * @param source A function that returns an input stream
     *
     * @return a FormatResult containing either [T] or null, if the stream does not contain the data to form an object of type [T]
     */
    override suspend fun read(context: SpiralContext, readContext: FormatReadContext?, source: DataSource<*>): KorneaResult<SrdArchive> =
            SrdArchive(context, source)
                .filter { srd -> srd.entries.isNotEmpty() }
                .buildFormatResult { srd -> if (srd.entries.size == 1) 0.4 else 0.5 }
}
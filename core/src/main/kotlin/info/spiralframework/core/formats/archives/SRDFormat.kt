package info.spiralframework.core.formats.archives

import info.spiralframework.core.formats.FormatResult
import info.spiralframework.core.formats.ReadableSpiralFormat
import info.spiralframework.formats.archives.SRD
import info.spiralframework.formats.game.DRGame
import info.spiralframework.formats.utils.DataContext
import info.spiralframework.formats.utils.DataSource

object SRDFormat: ReadableSpiralFormat<SRD> {
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
    override fun read(name: String?, game: DRGame?, context: DataContext, source: DataSource): FormatResult<SRD> {
        val srd = SRD(source) ?: return FormatResult.Fail(1.0)

        if (srd.entries.size == 1)
            return FormatResult.Success(srd, 1.0)
        return FormatResult(srd, srd.entries.isNotEmpty(), 1.0) //Not positive on this one chief but we're going with it
    }
}
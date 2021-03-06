package info.spiralframework.formats.scripting.lin

data class TextEntry(override var text: String?, override var textID: Int): LinScript, LinTextScript {
    constructor(op: Int, args: IntArray): this(null, (args[0] shl 8) or args[1])

    override val opCode: Int = 0x02
    override val rawArguments: IntArray = intArrayOf(textID shr 8 and 0xFF, textID and 0xFF)
    override val writeBOM: Boolean = true

    override fun format(): String = "Text|${text?.replace("\n", "&br")}"
}
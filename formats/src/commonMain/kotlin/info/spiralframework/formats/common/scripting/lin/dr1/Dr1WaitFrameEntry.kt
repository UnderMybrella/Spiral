package info.spiralframework.formats.common.scripting.lin.dr1

import info.spiralframework.formats.common.scripting.lin.LinEntry

inline class Dr1WaitFrameEntry(override val rawArguments: IntArray) : LinEntry {
    constructor(): this(LinEntry.EMPTY_ARGUMENT_ARRAY)
    constructor(opcode: Int, rawArguments: IntArray) : this(rawArguments)

    override val opcode: Int
        get() = 0x3B
}
package info.spiralframework.osl.drills.lin

import info.spiralframework.osl.OpenSpiralLanguageParser
import info.spiralframework.osl.drills.DrillHead
import info.spiralframework.formats.game.hpa.HopesPeakDRGame
import info.spiralframework.formats.game.hpa.UnknownHopesPeakGame
import info.spiralframework.formats.scripting.lin.LinScript
import info.spiralframework.formats.scripting.lin.UnknownEntry
import info.spiralframework.formats.utils.and
import org.parboiled.Rule
import kotlin.reflect.KClass

object BasicLinSpiralDrill : DrillHead<LinScript> {
    val cmd = "BASIC-LIN"

    override val klass: KClass<LinScript> = LinScript::class
    override fun OpenSpiralLanguageParser.syntax(): Rule =
            Sequence(
                    clearTmpStack(cmd),
                    Sequence(
                            "0x",
                            OneOrMore(Digit(16)),
                            pushDrillHead(cmd, this@BasicLinSpiralDrill),
                            pushTmpAction(cmd),
                            Optional(
                                    '|'
                            ),
                            Optional(
                                    ParamList(
                                            cmd,
                                            RuleWithVariables(OneOrMore(Digit())),
                                            Sequence(
                                                    ',',
                                                    OptionalInlineWhitespace()
                                            )
                                    )
                            )
                    ),

                    pushStackWithHead(cmd)
            )

    override fun operate(parser: OpenSpiralLanguageParser, rawParams: Array<Any>): LinScript = formScript(rawParams, parser.hopesPeakGame ?: UnknownHopesPeakGame)

    fun formScript(rawParams: Array<Any>, game: HopesPeakDRGame): LinScript {
        val opCode = "${rawParams[0]}".toInt(16)

        val params = rawParams.copyOfRange(1, rawParams.size).map { str -> "$str".toInt() }.toIntArray()

        val (_, argumentCount, getEntry) = game.opCodes[opCode] ?: (null to -1 and ::UnknownEntry)

        if (params.size == argumentCount || argumentCount == -1)
            return getEntry(opCode, params)
        throw IllegalArgumentException("Op Code 0x${rawParams[0]} has an invalid number of arguments (Has ${params.size}, expected $argumentCount)")
    }
}

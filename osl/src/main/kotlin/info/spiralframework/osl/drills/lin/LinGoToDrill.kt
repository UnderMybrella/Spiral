package info.spiralframework.osl.drills.lin

import info.spiralframework.formats.scripting.lin.GoToLabelEntry
import info.spiralframework.formats.scripting.lin.LinScript
import info.spiralframework.osl.OpenSpiralLanguageParser
import info.spiralframework.osl.drills.DrillHead
import org.parboiled.Rule
import kotlin.reflect.KClass

object LinGoToDrill : DrillHead<LinScript> {
    override val klass: KClass<LinScript> = LinScript::class
    val cmd = "LIN-GOTO"

    override fun OpenSpiralLanguageParser.syntax(): Rule =
            Sequence(
                    clearTmpStack(cmd),

                    Sequence(
                            FirstOf("Goto", "Go To"),
                            pushDrillHead(cmd, this@LinGoToDrill),
                            InlineWhitespace(),
                            Label(),
                            pushTmpFromStack(cmd),
                            pushTmpFromStack(cmd)
                    ),

                    pushStackWithHead(cmd)
            )

    override fun operate(parser: OpenSpiralLanguageParser, rawParams: Array<Any>): LinScript {
        val first = rawParams[0].toString().toIntOrNull() ?: 0
        val second = rawParams[1].toString().toIntOrNull() ?: 0

        return GoToLabelEntry.forGame(parser.drGame, (first shl 8) or second)
    }
}

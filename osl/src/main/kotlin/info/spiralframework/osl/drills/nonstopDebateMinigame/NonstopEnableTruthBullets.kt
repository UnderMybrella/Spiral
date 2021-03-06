package info.spiralframework.osl.drills.nonstopDebateMinigame

import info.spiralframework.osl.OpenSpiralLanguageParser
import info.spiralframework.osl.SpiralDrillBit
import info.spiralframework.osl.drills.DrillHead
import info.spiralframework.formats.scripting.lin.*
import org.parboiled.Action
import org.parboiled.Rule
import org.parboiled.support.Var
import kotlin.reflect.KClass

object NonstopEnableTruthBullets : DrillHead<Array<LinScript>> {
    override val klass: KClass<Array<LinScript>> = Array<LinScript>::class

    override fun OpenSpiralLanguageParser.syntax(): Rule {
        val evidenceCarrier = Var<MutableList<Int>>(ArrayList())
        val evidenceRule = Sequence(
                EvidenceID(),
                Action<Any> { evidenceCarrier.get().add(pop().toString().toIntOrNull() ?: 0) },
                ZeroOrMore(
                        Sequence(
                                CommaSeparator(),
                                EvidenceID(),
                                Action<Any> { evidenceCarrier.get().add(pop().toString().toIntOrNull() ?: 0) }
                        )
                )
        )
        return Sequence(
                Action<Any> { evidenceCarrier.get().clear(); true },
                Sequence(
                        Optional("Enable", InlineWhitespace()),
                        FirstOf("Truth Bullets", "Truth Bullet", "Evidence"),
                        FirstOf(
                                Sequence(
                                        ":",
                                        OptionalInlineWhitespace(),
                                        evidenceRule
                                ),
                                Sequence(
                                        OptionalInlineWhitespace(),
                                        "(",
                                        OptionalInlineWhitespace(),
                                        evidenceRule,
                                        OptionalInlineWhitespace(),
                                        ")"
                                )
                        )
                ),
                Action<Any> { context ->
                    push(listOf(SpiralDrillBit(this@NonstopEnableTruthBullets, context.match), evidenceCarrier.get().toIntArray()))
                }
        )
    }

    override fun operate(parser: OpenSpiralLanguageParser, rawParams: Array<Any>): Array<LinScript> {
        val label = parser.findLabel()
        val evidence = rawParams[0] as? IntArray ?: intArrayOf()
        return Array(evidence.size + 5) { i ->
            return@Array when (i) {
                0 -> ChangeUIEntry(20, 1)
                1 -> GoToLabelEntry(label)
                evidence.size + 2 -> ChoiceEntry(255)
                evidence.size + 3 -> SetLabelEntry(label)
                evidence.size + 4 -> ChangeUIEntry(20, 0)
                else -> ChoiceEntry(evidence[i - 2])
            }
        }
    }
}

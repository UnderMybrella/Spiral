package info.spiralframework.osl

import info.spiralframework.antlr.osl.OpenSpiralParser
import info.spiralframework.antlr.osl.OpenSpiralParserBaseVisitor
import info.spiralframework.formats.game.DRGame
import info.spiralframework.formats.scripting.CustomLin
import info.spiralframework.osl.games.*
import org.antlr.v4.runtime.tree.TerminalNode
import kotlin.properties.Delegates

class OSLVisitor : OpenSpiralParserBaseVisitor<OSLUnion>() {
    //var environment: String
    var game: DRGame? by Delegates.observable(null) { _, _: DRGame?, new: DRGame? ->
        gameVisitor = new?.let(DRGameVisitor.Companion::visitorFor)
    }
    var gameVisitor: DRGameVisitor? = null

    val lin: CustomLin = CustomLin()
    val variableData: MutableMap<String, OSLUnion> = HashMap()

    fun getData(name: String): OSLUnion {
        if (name.equals("game", true))
            return OSLUnion.RawStringType(game?.identifier ?: "none")
        else {
            return variableData[name] ?: OSLUnion.UndefinedType
        }
    }

    override fun visitScript(ctx: OpenSpiralParser.ScriptContext): OSLUnion {
        ctx.scriptLine().forEach { lineCtx -> gameVisitor?.handleScriptLine(visitScriptLine(lineCtx)) }
        return gameVisitor?.scriptResult() ?: OSLUnion.UndefinedType
    }

//    override fun visitScriptLine(ctx: OpenSpiralParser.ScriptLineContext): OSLUnion {
//        ctx.basicDrill()?.let { basicDrill -> return visitBasicDrill(basicDrill) }
//        ctx.basicDrillNamed()?.let { basicDrill -> return visitBasicDrillNamed(basicDrill) }
//
//        return OSLUnion.UndefinedType
//    }

    override fun visitBasicDrill(ctx: OpenSpiralParser.BasicDrillContext): OSLUnion {
        val opCode = ctx.BASIC_DRILL_CODE().text.trimEnd('|').toIntVariable()
        val arguments: MutableList<Int> = ArrayList()
        ctx.basicDrillValue().forEach { valueCtx -> gameVisitor?.handleArgumentForEntry(arguments, visitBasicDrillValue(valueCtx)) }
        return gameVisitor.entryForOpCode(opCode, arguments.toIntArray())
    }

    override fun visitBasicDrillNamed(ctx: OpenSpiralParser.BasicDrillNamedContext): OSLUnion {
        val opCodeName = ctx.BASIC_DRILL_NAME().text.trim('|')
        val arguments: MutableList<Int> = ArrayList()
        ctx.basicDrillValue().forEach { valueCtx -> gameVisitor?.handleArgumentForEntry(arguments, visitBasicDrillValue(valueCtx)) }
        return gameVisitor.entryForName(opCodeName, arguments.toIntArray())
    }

    override fun visitBasicDrillValue(ctx: OpenSpiralParser.BasicDrillValueContext): OSLUnion {
        ctx.wrdLabelReference()?.let(this::visitWrdLabelReference)?.let { return it }
        ctx.wrdParameterReference()?.let(this::visitWrdParameterReference)?.let { return it }
        ctx.variableValue()?.let(this::visitVariableValue)?.let { return it }

        return OSLUnion.UndefinedType
    }

    override fun visitWrdLabelReference(ctx: OpenSpiralParser.WrdLabelReferenceContext): OSLUnion {
        ctx.WRD_SHORT_LABEL_REFERENCE()?.let { node -> return OSLUnion.LabelType(node.text.substring(1)) }
        ctx.wrdLongLabelReference()?.let(this::visitWrdLongLabelReference)?.let { return it }

        return OSLUnion.UndefinedType
    }

    override fun visitWrdParameterReference(ctx: OpenSpiralParser.WrdParameterReferenceContext): OSLUnion {
        ctx.WRD_SHORT_PARAMETER_REFERENCE()?.let { node -> return OSLUnion.ParameterType(node.text.substring(1)) }
        ctx.wrdLongParameterReference()?.let(this::visitWrdLongParameterReference)?.let { return it }

        return OSLUnion.UndefinedType
    }

    override fun visitWrdLongLabelReference(ctx: OpenSpiralParser.WrdLongLabelReferenceContext): OSLUnion.LabelType =
            OSLUnion.LabelType(visitLongReference(ctx.longReference()).string)

    override fun visitWrdLongParameterReference(ctx: OpenSpiralParser.WrdLongParameterReferenceContext): OSLUnion.ParameterType =
            OSLUnion.ParameterType(visitLongReference(ctx.longReference()).string)

    override fun visitLongReference(ctx: OpenSpiralParser.LongReferenceContext): OSLUnion.RawStringType {
        val string = buildString {
            ctx.children.forEach { node ->
                if (node !is TerminalNode)
                    return@forEach

                when (node.symbol.type) {
                    OpenSpiralParser.LONG_REF_ESCAPES -> {
                        when (node.text[1]) {
                            'b' -> append('\b')
                            'f' -> append(0x0C.toChar())
                            'n' -> append('\n')
                            'r' -> append('\r')
                            't' -> append('\t')
                            'u' -> append(node.text.substring(2).toInt(16).toChar())
                        }
                    }
                    OpenSpiralParser.LONG_REF_CHARACTERS -> append(node.text)
                    OpenSpiralParser.LONG_REF_VARIABLE_REFERENCE -> append(getData(node.text.substring(1)).represent())
                }
            }
        }

        return OSLUnion.RawStringType(string)
    }

    override fun visitQuotedString(ctx: OpenSpiralParser.QuotedStringContext): OSLUnion.RawStringType {
        val string = buildString {
            var cltOpen = false
            ctx.children.forEach { node ->
                if (node !is TerminalNode)
                    return@forEach

                when (node.symbol.type) {
                    OpenSpiralParser.ESCAPES -> {
                        when (node.text[1]) {
                            'b' -> append('\b')
                            'f' -> append(0x0C.toChar())
                            'n' -> append('\n')
                            'r' -> append('\r')
                            't' -> append('\t')
                            'u' -> append(node.text.substring(2).toInt(16).toChar())
                        }
                    }
                    OpenSpiralParser.STRING_CHARACTERS -> append(node.text)
                    OpenSpiralParser.QUOTED_STRING_VARIABLE_REFERENCE -> append(getData(node.text.substring(1)).represent())
                    OpenSpiralParser.QUOTED_COLOUR_CODE -> {
                        val colourCode = node.text.substring(1).trim().let { str -> game?.colourCodes?.get(str) ?: str }
                        if (colourCode.equals("clear", true)) {
                            if (gameVisitor.clearCltCode(this)) {
                                cltOpen = false
                            } else {
                                append(colourCode)
                            }
                        } else {
                            if (gameVisitor.handleCltCode(this, colourCode)) {
                                cltOpen = true
                            } else {
                                append(colourCode)
                            }
                        }
                    }
                }
            }

            if (cltOpen)
                gameVisitor?.closeCltCode(this)
        }

        return OSLUnion.RawStringType(string)
    }

    override fun visitMetaVariableAssignment(ctx: OpenSpiralParser.MetaVariableAssignmentContext): OSLUnion {
        val name = ctx.ASSIGN_VARIABLE_NAME().text.substringAfter(' ')
        val value = visitVariableValue(ctx.variableValue())
        variableData[name] = value
        return OSLUnion.NoOpType
    }

    override fun visitVariableValue(ctx: OpenSpiralParser.VariableValueContext): OSLUnion {
        //        ctx.BASIC_LIN_DOUBLE()?.let { double -> return OSLUnion.NumberType(double.text.toDouble()) }
//        ctx.BASIC_LIN_INTEGER()?.let { integer -> return OSLUnion.NumberType(integer.text.toLongVariable()) }
//        ctx.BASIC_LIN_VARIABLE_REFERENCE()?.let { varRef -> return getData(varRef.text.substring(1)) }
//        ctx.BASIC_LIN_BOOLEAN()?.let { boolean -> return OSLUnion.BooleanType(boolean.text.toBoolean()) }
//        ctx.BASIC_LIN_NULL()?.let { return OSLUnion.NullType }
//        ctx.basicDrillQuotedString()?.let(this::visitBasicDrillQuotedString)?.let { return it }

        ctx.DECIMAL_NUMBER()?.let { double -> return OSLUnion.NumberType(double.text.toDouble()) }
        ctx.INTEGER()?.let { integer -> return OSLUnion.NumberType(integer.text.toLongVariable()) }
        ctx.VARIABLE_REFERENCE()?.let { varRef -> return getData(varRef.text.substring(1)) }
//        ctx.LOCALISED_STRING()
        ctx.BOOLEAN()?.let { boolean -> return OSLUnion.BooleanType(boolean.text.toBoolean()) }
        ctx.NULL()?.let { return OSLUnion.NullType }

        ctx.quotedString()?.let(this::visitQuotedString)?.let { return it }

        return OSLUnion.UndefinedType
    }

    fun String.toIntVariable(): Int = when {
        startsWith("0b") -> substring(2).toInt(2)
        startsWith("0o") -> substring(2).toInt(8)
        startsWith("0x") -> substring(2).toInt(16)
        startsWith("0d") -> substring(2).toInt()
        else -> toInt()
    }

    fun String.toLongVariable(): Long = when {
        startsWith("0b") -> substring(2).toLong(2)
        startsWith("0o") -> substring(2).toLong(8)
        startsWith("0x") -> substring(2).toLong(16)
        startsWith("0d") -> substring(2).toLong()
        else -> toLong()
    }
}
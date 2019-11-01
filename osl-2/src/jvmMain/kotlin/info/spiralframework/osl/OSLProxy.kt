package info.spiralframework.osl

import info.spiralframework.antlr.osl.OpenSpiralLexer
import info.spiralframework.antlr.osl.OpenSpiralParser
import info.spiralframework.base.binding.DefaultSpiralResourceLoader
import info.spiralframework.base.binding.defaultSpiralContext
import info.spiralframework.base.common.SpiralModuleBase
import info.spiralframework.base.common.io.SpiralResourceLoader
import info.spiralframework.base.common.locale.CommonLocale
import info.spiralframework.base.common.locale.loadWithLocale
import info.spiralframework.formats.customLin
import info.spiralframework.formats.game.v3.V3
import info.spiralframework.formats.scripting.WordScriptFile
import info.spiralframework.formats.scripting.lin.*
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import java.io.File

object OSLProxy {
    @JvmStatic
    suspend fun main(args: Array<String>) {
        osl()
    }

    suspend fun locale() {
//        val input = CharStreams.fromString(buildString {
//            val data = SpiralLocale::class.java.classLoader.getResourceAsStream("SpiralBase.properties")?.let(InputStream::readBytes)
//                    ?: return@buildString
//            appendln(String(data, Charsets.UTF_8))
//        })
//        val lexer = OSLLocaleLexer(input)
//        val tokens = CommonTokenStream(lexer)
//        val parser = OSLLocaleParser(tokens)
//        val tree = parser.locale()
//        val visitor = LocaleVisitor()
//        visitor.visit(tree)
//        val bundle = visitor.createResourceBundle()
//        println(bundle.keys.toList())
//
//        SpiralLocale.PROMPT_AFFIRMATIVE
//
//        println()

        val resourceLoader: SpiralResourceLoader = DefaultSpiralResourceLoader()
        val bundle = OSLLocaleBundle.loadBundle<SpiralModuleBase>(resourceLoader, "SpiralBase")
        println(bundle?.loadWithLocale(resourceLoader, CommonLocale.CHINESE)?.locale)


//        println(visitor.visit(tree))
//        val visitor = OSLVisitor()
//        println(visitor.visitScript(tree).represent())
    }

    suspend fun osl() {
        val input = CharStreams.fromFileName("osl-2/src/main/antlr/tests/NonstopDebate.osl")
        val lexer = OpenSpiralLexer(input)
        val tokens = CommonTokenStream(lexer)
        val parser = OpenSpiralParser(tokens)
        val tree = parser.script()
        val visitor = OSLVisitor()
        //visitor.game = DR1
        val result = visitor.visitScript(tree)
        println(result.represent())

        when (result) {
            is OSLUnion.CustomWrdType -> {
                File("custom.wrd").outputStream().use(result.wrd::compile)

                val loadedWrd = WordScriptFile(defaultSpiralContext(), V3, File("custom.wrd")::inputStream)
                println(loadedWrd)
            }
        }

//        when (val result = visitor.visit(tree)) {
//            is OSLUnion.CustomLinType -> {
//                result.lin.writeTextBOM = true
//                File("C:\\Program Files (x86)\\Steam\\steamapps\\common\\Danganronpa Another Episode Ultra Despair Girls\\data\\_scr\\en\\e00_000_200.lin").outputStream().use(result.lin::compile)
//            }
//        }
    }

    fun customLinStuff() {
        val lin = customLin {
            add(ScreenFadeEntry(fadeIn = true, colour = 0, frameDuration = 24))

            add(SetFlagEntry(0, 4, 1))
            add(SetFlagEntry(0, 5, 1))
            add(SetFlagEntry(0, 6, 1))
            add(SetFlagEntry(0, 7, 1))

//            add(TextEntry("Awaiting input...", -1))
//            add(WaitForInputEntry.DR1)
//
//            for (i in 0 until 255) {
//                add(TextEntry("<CLT $i>CLT $i<CLT>", -1))
//                add(UnknownEntry(0x33, intArrayOf(6, 0, 0, 60)))
//            }

            add(TextEntry("Of course.\nI'm<CLT 030 an esper<CLT> test", -1))
            add(WaitForInputEntry.DR1)

            add(StopScriptEntry())
            add(StopScriptEntry())
        }

        File("C:\\Program Files (x86)\\Steam\\steamapps\\common\\Danganronpa Trigger Happy Havoc\\content\\Dr1\\data\\us\\script\\e00_001_000.lin")
                .outputStream().use(lin::compile)
    }
}
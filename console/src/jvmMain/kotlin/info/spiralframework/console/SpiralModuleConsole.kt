package info.spiralframework.console

import info.spiralframework.base.common.SPIRAL_VERSION
import info.spiralframework.base.common.SemanticVersion
import info.spiralframework.base.common.SpiralContext
import info.spiralframework.base.common.SpiralModuleProvider
import info.spiralframework.base.common.locale.loadBundle

class SpiralModuleConsole: SpiralModuleProvider {
    override val moduleName: String = "spiral-console"
    override val moduleVersion: SemanticVersion = SPIRAL_VERSION

    override suspend fun register(context: SpiralContext) {
        context.loadBundle<SpiralModuleConsole>(context, "SpiralConsole")
        context.loadBundle<SpiralModuleConsole>(context, "SpiralConsole-Mechanic")
        context.loadBundle<SpiralModuleConsole>(context, "SpiralConsole-Pilot")
    }
}
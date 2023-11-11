package namechanger

import namechanger.commands.NameChangerCommands
import namechanger.config.NameChangerConfig
import net.minecraft.client.Minecraft
import net.minecraftforge.client.ClientCommandHandler
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import java.io.File

@Mod(
    modid = NameChanger.MOD_ID, name = NameChanger.MOD_NAME, version = NameChanger.MOD_VERSION
)
class NameChanger {

    @Mod.EventHandler
    fun onInit(event: FMLInitializationEvent) {
        ClientCommandHandler.instance.registerCommand((NameChangerCommands()))
    }

    companion object {
        const val MOD_ID = "namechanger"
        const val MOD_NAME = "NameChanger"
        const val MOD_VERSION = "1.0"
        val config = NameChangerConfig(File(Minecraft.getMinecraft().mcDataDir, "config"))

        fun replaceString(old: String): String {
            config.name?.let {
                return old.replace(Minecraft.getMinecraft().session.profile.name, it)
            }
            return old
        }
    }
}

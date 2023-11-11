package namechanger.commands

import gg.essential.universal.UChat
import namechanger.NameChanger.Companion.config
import net.minecraft.command.CommandBase
import net.minecraft.command.ICommandSender

class NameChangerCommands : CommandBase() {

    override fun getCommandName(): String = "namechanger"

    override fun getCommandAliases(): List<String> = listOf("nc", "namechange", "fakename", "hidename")

    override fun getCommandUsage(sender: ICommandSender): String = "/$commandName <name>"

    override fun getRequiredPermissionLevel(): Int = 0

    override fun processCommand(sender: ICommandSender, args: Array<String>) {
        if (args.isEmpty()) {
            config.name = null
            UChat.chat("&7Your fake name has been &breset&7. To set a new name use &b/namechanger <name>.")
            return
        }

        val newName = args.joinToString(" ")
        config.name = newName
        UChat.chat("&7Your fake name has been set to &r$newName.")
    }
}

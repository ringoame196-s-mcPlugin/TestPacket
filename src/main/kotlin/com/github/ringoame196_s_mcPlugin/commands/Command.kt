package com.github.ringoame196_s_mcPlugin.commands

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.ProtocolLibrary
import com.comphenix.protocol.events.PacketContainer
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter
import org.bukkit.entity.Player

class Command : CommandExecutor, TabCompleter {
    private val protocolLibraryManager = ProtocolLibrary.getProtocolManager()

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (args.isEmpty()) return false
        val subCommand = args[0]

        when (subCommand) {
            CommandConst.EXPLOSION_COMMAND -> explosion(sender)
            else -> false
        }

        return true
    }

    private fun explosion(sender: CommandSender) {
        val player = sender as? Player ?: return
        val loc = player.location
        val packet = PacketContainer(PacketType.Play.Server.EXPLOSION)

        // 爆発位置を指定
        packet.doubles.writeSafely(0, loc.x)
        packet.doubles.writeSafely(1, loc.y)
        packet.doubles.writeSafely(2, loc.z)

        // 爆発の強さ（見た目の大きさ）
        packet.float.writeSafely(0, 15.0f)

        // プレイヤーを上方向へ飛ばす加速度 (motionX, motionY, motionZ)
        packet.float.writeSafely(1, 0.0f) // X方向の力
        packet.float.writeSafely(2, 1.0f) // Y方向の力（上に飛ばす）
        packet.float.writeSafely(3, 0.0f) // Z方向の力

        protocolLibraryManager.sendServerPacket(player, packet)
    }

    override fun onTabComplete(commandSender: CommandSender, command: Command, label: String, args: Array<out String>): MutableList<String>? {
        return mutableListOf(
            CommandConst.EXPLOSION_COMMAND
        )
    }
}

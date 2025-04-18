package com.github.ringoame196_s_mcPlugin.events

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.events.ListenerPriority
import com.comphenix.protocol.events.PacketAdapter
import com.comphenix.protocol.events.PacketEvent
import com.comphenix.protocol.wrappers.EnumWrappers
import org.bukkit.plugin.Plugin

class PlayerInfo(plugin: Plugin) : PacketAdapter(plugin, ListenerPriority.NORMAL, PacketType.Play.Server.PLAYER_INFO) {
    override fun onPacketSending(e: PacketEvent?) {
        val packet = e?.packet ?: return

        val player = e.player

        val debugText = packet.handle.toString()

        val playerInfoData = packet.playerInfoDataLists.read(1).toList()[0]
        val gameMode = playerInfoData.gameMode
        val senderUUID = playerInfoData.profile.id

        // player.sendMessage("$senderUUID")

        plugin.logger.info(debugText)

        if (gameMode == EnumWrappers.NativeGameMode.SPECTATOR && senderUUID != player.uniqueId.toString()) {
            e.isCancelled = true
        }
    }
}

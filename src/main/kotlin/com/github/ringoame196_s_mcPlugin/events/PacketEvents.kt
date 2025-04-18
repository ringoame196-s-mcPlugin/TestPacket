package com.github.ringoame196_s_mcPlugin.events

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.ProtocolLibrary
import com.comphenix.protocol.events.ListenerPriority
import com.comphenix.protocol.events.PacketAdapter
import com.comphenix.protocol.events.PacketEvent
import org.bukkit.plugin.Plugin

class PacketEvents(plugin: Plugin) : PacketAdapter(plugin, ListenerPriority.NORMAL, PacketType.Play.Server.PLAYER_INFO) {
    private val protocolLibraryManager = ProtocolLibrary.getProtocolManager()

	/*
	override fun onPacketReceiving(e: PacketEvent?) {
		val packet = e?.packet ?: return
	}
	 */

    override fun onPacketSending(e: PacketEvent?) {
    }
}

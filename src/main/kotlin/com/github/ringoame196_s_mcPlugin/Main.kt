package com.github.ringoame196_s_mcPlugin

import com.comphenix.protocol.ProtocolLibrary
import com.github.ringoame196_s_mcPlugin.commands.Command
import com.github.ringoame196_s_mcPlugin.events.Events
import com.github.ringoame196_s_mcPlugin.events.PacketEvents
import com.github.ringoame196_s_mcPlugin.events.PlayerInfo
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {
    private val plugin = this
    override fun onEnable() {
        super.onEnable()
        server.pluginManager.registerEvents(Events(), plugin)
        val command = getCommand("testp")
        command!!.setExecutor(Command())

        val protocolLibraryManager = ProtocolLibrary.getProtocolManager()
        protocolLibraryManager.addPacketListener(PacketEvents(plugin))
        protocolLibraryManager.addPacketListener(PlayerInfo(plugin))
    }
}

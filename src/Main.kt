package me.loyfael.plugin

import org.bukkit.plugin.java.JavaPlugin

/**
 * Plugin KotlinPaperMCPluginBoilerPlate
 * This is a simple boilerplate for a PaperMC plugin written in Kotlin.
 * It serves as a starting point for developing your own plugins.
 *
 * Main class is unused because of the Kotlin DSL. It is here for reference.
 * Used inside the plugin.yml file.
 */
class Main : JavaPlugin() {
    override fun onEnable() {
        logger.info("Plugin KotlinPaperMCPluginBoilerPlate activé !")
    }

    override fun onDisable() {
        logger.info("Plugin KotlinPaperMCPluginBoilerPlate désactivé !")
    }
}
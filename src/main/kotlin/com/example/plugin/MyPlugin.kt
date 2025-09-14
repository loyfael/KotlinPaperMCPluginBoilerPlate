package com.example.plugin

import org.bukkit.plugin.java.JavaPlugin
import java.util.logging.Level

/**
 * Classe principale du plugin MyPlugin
 * 
 * Cette classe hérite de JavaPlugin et contient les méthodes
 * d'activation et de désactivation du plugin.
 */
class MyPlugin : JavaPlugin() {
    
    companion object {
        /**
         * Instance statique du plugin pour accès global
         */
        lateinit var instance: MyPlugin
            private set
    }
    
    // === Managers ===
    private lateinit var configManager: ConfigManager
    private lateinit var databaseManager: DatabaseManager
    
    /**
     * Méthode appelée lors de l'activation du plugin
     */
    override fun onEnable() {
        // Initialisation de l'instance statique
        instance = this
        
        logger.info("§a=== Démarrage de MyPlugin ===")
        
        try {
            // Initialisation de la configuration
            initializeConfig()
            
            // Initialisation de la base de données
            initializeDatabase()
            
            // Enregistrement des commandes
            registerCommands()
            
            // Enregistrement des listeners
            registerListeners()
            
            // Initialisation des tâches
            initializeTasks()
            
            logger.info("§aMyPlugin activé avec succès ! Version: ${pluginMeta.version}")
            
        } catch (e: Exception) {
            logger.log(Level.SEVERE, "Erreur lors de l'activation du plugin !", e)
            isEnabled = false
            return
        }
    }
    
    /**
     * Méthode appelée lors de la désactivation du plugin
     */
    override fun onDisable() {
        logger.info("§c=== Arrêt de MyPlugin ===")
        
        try {
            // Fermeture de la base de données
            if (::databaseManager.isInitialized) {
                databaseManager.close()
            }
            
            // Arrêt des tâches
            server.scheduler.cancelTasks(this)
            
            logger.info("§cMyPlugin désactivé avec succès !")
            
        } catch (e: Exception) {
            logger.log(Level.SEVERE, "Erreur lors de la désactivation du plugin !", e)
        }
    }
    
    /**
     * Initialise la configuration du plugin
     */
    private fun initializeConfig() {
        // Sauvegarde de la configuration par défaut si elle n'existe pas
        saveDefaultConfig()
        
        // Initialisation du gestionnaire de configuration
        configManager = ConfigManager(this)
        
        logger.info("Configuration initialisée")
    }
    
    /**
     * Initialise la base de données
     */
    private fun initializeDatabase() {
        databaseManager = DatabaseManager(this)
        databaseManager.initialize()
        
        logger.info("Base de données initialisée")
    }
    
    /**
     * Enregistre les commandes du plugin
     */
    private fun registerCommands() {
        // Commande principale
        getCommand("myplugin")?.setExecutor(MainCommand(this))
        
        // Commandes supplémentaires
        // getCommand("mycommand")?.setExecutor(MyCommand(this))
        
        logger.info("Commandes enregistrées")
    }
    
    /**
     * Enregistre les listeners du plugin
     */
    private fun registerListeners() {
        // server.pluginManager.registerEvents(MyListener(this), this)
        
        logger.info("Listeners enregistrés")
    }
    
    /**
     * Initialise les tâches répétitives
     */
    private fun initializeTasks() {
        // Exemple de tâche répétitive (toutes les 5 minutes)
        val autoSaveInterval = configManager.getAutoSaveInterval()
        if (autoSaveInterval > 0) {
            server.scheduler.runTaskTimerAsynchronously(this, Runnable {
                // Sauvegarde automatique
                if (configManager.isDebugEnabled()) {
                    logger.info("Sauvegarde automatique...")
                }
            }, 20L * 60L * autoSaveInterval, 20L * 60L * autoSaveInterval)
        }
        
        logger.info("Tâches initialisées")
    }
    
    /**
     * Recharge la configuration du plugin
     */
    fun reloadPluginConfig() {
        reloadConfig()
        configManager = ConfigManager(this)
        logger.info("Configuration rechargée")
    }
    
    // === Getters pour les managers ===
    
    fun getConfigManager(): ConfigManager = configManager
    
    fun getDatabaseManager(): DatabaseManager = databaseManager
}

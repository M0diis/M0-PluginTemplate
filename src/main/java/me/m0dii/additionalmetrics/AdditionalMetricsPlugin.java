package me.m0dii.additionalmetrics;

import com.earth2me.essentials.Essentials;
import dev.cubxity.plugins.metrics.api.UnifiedMetrics;
import lombok.Getter;
import me.m0dii.additionalmetrics.collectors.ServerBalanceCollectorCollection;
import me.m0dii.additionalmetrics.collectors.UniquePlayerCollectorCollection;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Optional;

public class AdditionalMetricsPlugin extends JavaPlugin {
    @Getter
    private static AdditionalMetricsPlugin instance;

    @Getter
    private Essentials essentials;

    public void onEnable() {
        instance = this;

        PluginManager pm = getServer().getPluginManager();

        if (pm.getPlugin("Essentials") != null) {
            this.essentials = (Essentials) pm.getPlugin("Essentials");
        }

        loadCustomMetrics();

        Bukkit.getLogger().info("");
        Bukkit.getLogger().info("  __  __  ___  ");
        Bukkit.getLogger().info(" |  \\/  |/ _ \\ ");
        Bukkit.getLogger().info(" | \\  / | | | |");
        Bukkit.getLogger().info(" | |\\/| | | | |");
        Bukkit.getLogger().info(" | |  | | |_| |");
        Bukkit.getLogger().info(" |_|  |_|\\___/");
        Bukkit.getLogger().info("");
        Bukkit.getLogger().info("AdditionalMetrics has been enabled!");
    }

    private void loadCustomMetrics() {
        Optional.ofNullable(getServer().getServicesManager().getRegistration(UnifiedMetrics.class))
                .ifPresent(registration -> {
                    UnifiedMetrics api = registration.getProvider();

                    api.getMetricsManager().registerCollection(new ServerBalanceCollectorCollection());
                    api.getMetricsManager().registerCollection(new UniquePlayerCollectorCollection());
                });
    }

    public void onDisable() {
        Bukkit.getLogger().info("AdditionalMetrics has been disabled.");
    }
}

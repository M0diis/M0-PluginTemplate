package me.m0dii.plugintemplate;

import lombok.Getter;
import me.m0dii.plugintemplate.commands.Cmd;
import me.m0dii.plugintemplate.utils.Messenger;
import org.bukkit.command.PluginCommand;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class TemplatePlugin extends JavaPlugin {
    @Getter
    private static TemplatePlugin instance;

    private PluginManager pm;

    public void onEnable() {
        instance = this;

        this.pm = getServer().getPluginManager();

        Messenger.info("");
        Messenger.info("  __  __  ___  ");
        Messenger.info(" |  \\/  |/ _ \\ ");
        Messenger.info(" | \\  / | | | |");
        Messenger.info(" | |\\/| | | | |");
        Messenger.info(" | |  | | |_| |");
        Messenger.info(" |_|  |_|\\___/");
        Messenger.info("");
        Messenger.info("SamplePlugin has been enabled!");
    }

    public void onDisable() {
        Messenger.info("SamplePlugin has been disabled.");
    }

    private void prepareConfig() {
        File configFile = new File(this.getDataFolder(), "config.yml");

        if (!configFile.exists()) {
            //noinspection ResultOfMethodCallIgnored
            configFile.getParentFile().mkdirs();

            this.copy(this.getResource("config.yml"), configFile);
        }

        YamlConfiguration.loadConfiguration(configFile);
    }

    private void copy(InputStream in, File file) {
        if (in != null) {
            try {
                OutputStream out = new FileOutputStream(file);

                byte[] buf = new byte[1024];

                int len;

                while ((len = in.read(buf)) > 0)
                    out.write(buf, 0, len);

                out.close();
                in.close();
            } catch (Exception ex) {
                Messenger.warn("Error copying config file..");

                Messenger.debug(ex.getMessage());
            }
        }
    }
}

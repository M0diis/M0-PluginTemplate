package me.m0dii.plugintemplate.utils;

import me.m0dii.plugintemplate.TemplatePlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class Messenger
{
    private static final TemplatePlugin plugin = TemplatePlugin.getInstance();
    
    public static void sendf(CommandSender s, String message)
    {
        s.sendMessage(format(message));
    }
    
    public static void sendfr(CommandSender s, String message, String what, Object to)
    {
        sendf(s, replace(message, what, to));
    }
    
    public static String replace(String in, String what, Object to)
    {
        return in.replace(what, String.valueOf(to));
    }
    
    public static String format(String text)
    {
        return ChatColor.translateAlternateColorCodes('&', text);
    }
    
    public static void debug(String msg)
    {
        if(plugin.getCfg().DEBUG())
        {
            String prefix = "&3[&b" + TemplatePlugin.PLUGIN_NAME + " - DEBUG&3]&r ";
    
            Bukkit.getConsoleSender().sendMessage(format(prefix + msg));
        }
    }
    
    public static void info(String msg)
    {
        String prefix = "&2[&a" + TemplatePlugin.PLUGIN_NAME + " - INFO&2]&r ";
    
        Bukkit.getConsoleSender().sendMessage(format(prefix + msg));
    }
    
    public static void warn(String msg)
    {
        String prefix = "&6[&e" + TemplatePlugin.PLUGIN_NAME + " - WARN&6]&r ";
    
        Bukkit.getConsoleSender().sendMessage(format(prefix + msg));
    }
}
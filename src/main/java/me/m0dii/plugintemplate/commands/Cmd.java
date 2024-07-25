package me.m0dii.plugintemplate.commands;

import me.m0dii.plugintemplate.TemplatePlugin;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Cmd implements CommandExecutor
{
    private final TemplatePlugin plugin;
    
    public Cmd(TemplatePlugin plugin)
    {
        this.plugin = plugin;
    }
    
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull org.bukkit.command.Command cmd,
                             @NotNull String alias, @NotNull String[] args)
    {
        if(sender instanceof ConsoleCommandSender)
        {

        }
        
        if(sender instanceof Player p)
        {

        }
        
        return true;
    }
    
    private static boolean isCommand(String[] args, String cmd, String perm, Player pl)
    {
        return args[0].equalsIgnoreCase(cmd) && pl.hasPermission(perm);
    }
}

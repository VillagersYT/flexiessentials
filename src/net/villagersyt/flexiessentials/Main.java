package net.villagersyt.flexiessentials;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

import net.villagersyt.flexiessentials.commands.gmcCommand;
import net.villagersyt.flexiessentials.commands.gmsCommand;
import net.villagersyt.flexiessentials.commands.gmaCommand;
import net.villagersyt.flexiessentials.commands.gmspCommand;
import net.villagersyt.flexiessentials.commands.flyCommand;
import net.villagersyt.flexiessentials.commands.godCommand;
import net.villagersyt.flexiessentials.commands.healCommand;
import net.villagersyt.flexiessentials.commands.feedCommand;
import net.villagersyt.flexiessentials.listeners.GodModeListener;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		
		Bukkit.getConsoleSender().sendMessage("§aFlexiEssentials has successfully enable !");
		
		this.getCommand("gmc").setExecutor((CommandExecutor) new gmcCommand());
		this.getCommand("gms").setExecutor((CommandExecutor) new gmsCommand());
		this.getCommand("gma").setExecutor((CommandExecutor) new gmaCommand());
		this.getCommand("gmsp").setExecutor((CommandExecutor) new gmspCommand());
		this.getCommand("fly").setExecutor((CommandExecutor) new flyCommand());
		this.getCommand("god").setExecutor((CommandExecutor) new godCommand());
		this.getCommand("heal").setExecutor((CommandExecutor) new healCommand());
		this.getCommand("feed").setExecutor((CommandExecutor) new feedCommand());
		
		getServer().getPluginManager().registerEvents(new GodModeListener(godCommand.getGodModePlayers()), this);
		
		super.onEnable();
	}
	
	@Override
	public void onDisable() {

		Bukkit.getConsoleSender().sendMessage("§cFlexiEssentials has correctly disable !");
		
		super.onDisable();
	}
}
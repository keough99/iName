package com.github.pocketkid2.name;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.pocketkid2.name.commands.LoreCommand;
import com.github.pocketkid2.name.commands.NameCommand;

public class NamePlugin extends JavaPlugin {

	@Override
	public void onEnable() {
		// Register commands
		getCommand("name").setExecutor(new NameCommand(this));
		getCommand("lore").setExecutor(new LoreCommand(this));

		// Log status
		getLogger().info("done!");
	}

	@Override
	public void onDisable() {
		// Log status
		getLogger().info("done!");
	}

	// stitch together an array of strings
	public String stitch(String[] args) {
		return String.join(" ", args);
	}

	// Add colors
	public String colors(String s) {
		return ChatColor.translateAlternateColorCodes('&', s);
	}
}

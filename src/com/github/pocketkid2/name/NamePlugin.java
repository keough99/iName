package com.github.pocketkid2.name;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.pocketkid2.name.commands.NameCommand;

public class NamePlugin extends JavaPlugin {

	@Override
	public void onEnable() {
		// Register command
		getCommand("name").setExecutor(new NameCommand(this));

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
		StringBuilder name = new StringBuilder();
		for (String s : args) {
			name.append(s);
			name.append(' ');
		}
		name.deleteCharAt(name.length() - 1);
		return name.toString();
	}

	// Add colors
	public String colors(String s) {
		return ChatColor.translateAlternateColorCodes('&', s);
	}
}

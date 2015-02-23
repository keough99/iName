package com.github.pocketkid2.name;

import org.bukkit.plugin.java.JavaPlugin;

import com.github.pocketkid2.name.commands.NameCommand;

public class NamePlugin extends JavaPlugin {

	public void onEnable() {
		// Register command
		this.getCommand("name").setExecutor(new NameCommand(this));
		
		// Log status
		this.getLogger().info("done!");
	}
	
	public void onDisable() {
		// Log status
		this.getLogger().info("done!");
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
}

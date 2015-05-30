package com.github.pocketkid2.name;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.pocketkid2.name.commands.LoreCommand;
import com.github.pocketkid2.name.commands.NameCommand;

public class NamePlugin extends JavaPlugin {

	@Override
	public void onEnable() {
		// Register Commands
		getCommand("name").setExecutor(new NameCommand(this));
		getCommand("lore").setExecutor(new LoreCommand(this));

		// Log status
		getLogger().info("Done!");
	}

	@Override
	public void onDisable() {
		// Log status
		getLogger().info("Done!");
	}

	public void setName(ItemStack stack, String name) {
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName(name);
		stack.setItemMeta(meta);
	}

	public void resetName(ItemStack stack) {
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName("");
		stack.setItemMeta(meta);
	}

	public void appendLore(ItemStack stack, String lore) {
		ItemMeta meta = stack.getItemMeta();
		List<String> lores = null;
		if (meta.hasLore()) {
			lores = meta.getLore();
		} else {
			lores = new ArrayList<String>();
		}
		lores.add(lore);
		meta.setLore(lores);
		stack.setItemMeta(meta);
	}

	public void resetLores(ItemStack stack) {
		ItemMeta meta = stack.getItemMeta();
		if (meta.hasLore()) {
			List<String> lores = meta.getLore();
			lores.clear();
			meta.setLore(lores);
		}
		stack.setItemMeta(meta);
	}
}

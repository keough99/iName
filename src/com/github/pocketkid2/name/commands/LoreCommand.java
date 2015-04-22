package com.github.pocketkid2.name.commands;

import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.github.pocketkid2.name.NamePlugin;

public class LoreCommand implements CommandExecutor {

	// Main class reference
	public NamePlugin plugin;

	// Constructor
	public LoreCommand(NamePlugin pl) {
		plugin = pl;
	}

	// Command method
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// Check for player
		if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "You have to be a player!");
			return true;
		}

		// Check for permission
		if (!(sender.hasPermission("iname.command.lore"))) {
			sender.sendMessage(ChatColor.RED + "You can't do that!");
			return true;
		}

		// Create player object
		Player player = (Player) sender;

		// Check for item
		if (player.getItemInHand() == null || player.getItemInHand().getType() == Material.AIR) {
			player.sendMessage(ChatColor.RED + "You aren't holding anything!");
			return true;
		}

		// Create item object
		ItemStack stack = player.getItemInHand();
		ItemMeta meta = stack.getItemMeta();

		// Check for no args
		if (args.length == 0) {
			// Remove lore
			meta.setLore(null);
			player.sendMessage(ChatColor.AQUA + "Lore cleared!");
		} else {
			// Set lore
			String lore = plugin.colors(plugin.stitch(args));
			meta.setLore(Arrays.asList(lore));
			player.sendMessage(ChatColor.AQUA + "Lore changed!");
		}

		// Cleanup
		stack.setItemMeta(meta);
		player.setItemInHand(stack);

		return true;
	}

}

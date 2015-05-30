package com.github.pocketkid2.name.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.github.pocketkid2.name.NamePlugin;
import com.github.pocketkid2.name.utils.Messages;

public class NameCommand implements CommandExecutor {

	private NamePlugin plugin;

	public NameCommand(NamePlugin pl) {
		plugin = pl;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// Check for player
		if (!(sender instanceof Player)) {
			sender.sendMessage(Messages.MUST_BE_PLAYER);
			return true;
		}

		// Check for permission
		if (!(sender.hasPermission("iname.command.name"))) {
			sender.sendMessage(Messages.NO_PERM);
			return true;
		}

		// Create first object
		Player player = (Player) sender;

		// Check for item in hand
		if (player.getItemInHand().getType() == Material.AIR) {
			player.sendMessage(Messages.NOT_HOLDING_ANYTHING);
			return true;
		}

		// Create second object
		ItemStack stack = player.getItemInHand();

		// Check for first argument
		if (args.length < 1) {
			plugin.resetName(stack);
			player.sendMessage(Messages.NAME_RESET);
		} else {
			plugin.setName(stack, ChatColor.translateAlternateColorCodes('&', String.join(" ", args)));
			player.sendMessage(Messages.NAME_SET);
		}

		return true;

	}
}

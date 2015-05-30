package com.github.pocketkid2.name.utils;

import org.bukkit.ChatColor;

public interface Messages {
	String MUST_BE_PLAYER = ChatColor.RED + "You must be a player!";
	String NO_PERM = ChatColor.RED + "You don't have permission for that!";
	String NOT_HOLDING_ANYTHING = ChatColor.RED + "You aren't holding anything!";
	String NAME_RESET = ChatColor.AQUA + "Item name reset!";
	String NAME_SET = ChatColor.AQUA + "Item name set!";
	String LORE_RESET = ChatColor.AQUA + "Item lores reset!";
	String LORE_ADDED = ChatColor.AQUA + "Item lore added!";
}

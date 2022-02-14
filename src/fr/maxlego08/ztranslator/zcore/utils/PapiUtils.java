package fr.maxlego08.ztranslator.zcore.utils;

import java.util.List;
import java.util.stream.Collectors;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class PapiUtils {

	public PapiUtils() {
	}

	/**
	 * 
	 * @param itemStack
	 * @param player
	 * @return
	 */
	protected ItemStack papi(ItemStack itemStack, Player player) {
		return itemStack;

	}

	/**
	 * 
	 * @param placeHolder
	 * @param player
	 * @return string
	 */
	public String papi(String placeHolder, Player player) {
		return placeHolder;
	}

	/**
	 * Transforms a list into a list with placeholder API
	 * 
	 * @param placeHolder
	 * @param player
	 * @return
	 */
	public List<String> papi(List<String> placeHolder, Player player) {
		return placeHolder == null ? null : placeHolder.stream().map(e -> papi(e, player)).collect(Collectors.toList());
	}

}
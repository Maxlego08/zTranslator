package fr.maxlego08.ztranslator.api;

import java.util.Optional;

import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

import fr.maxlego08.ztranslator.zcore.utils.storage.Saveable;

public interface Translator extends Saveable {

	/**
	 * Get {@link Translation} by language
	 * 
	 * @param lang
	 * @return optional of {@link Translation}
	 */
	public Optional<Translation> getTranslation(String lang);

	/**
	 * Translate material using default language
	 * 
	 * @param material
	 * @return translated material
	 */
	public String translate(Material material);

	/**
	 * Translate material using language in parameter
	 * 
	 * @param translation
	 * @param material
	 * @return translated material
	 */
	public String translate(String translation, Material material);

	/**
	 * Translate itemStack using default language
	 * 
	 * @param itemStack
	 * @return translated material
	 */
	public String translate(ItemStack itemStack);

	/**
	 * Translate itemStack using language in parameter
	 * 
	 * @param translation
	 * @param itemStack
	 * @return translated itemStack
	 */
	public String translate(String translation, ItemStack itemStack);
	
	
	/**
	 * Translate itemStack using language of player
	 * 
	 * @param player
	 * @param itemStack
	 * @return translated itemStack
	 */
	public String translate(OfflinePlayer player, ItemStack itemStack);

	/**
	 * Translate entity type using default language
	 * 
	 * @param entityType
	 * @return translated entity
	 */
	public String translate(EntityType entityType);
	
	/**
	 * Translate entity type using default language
	 * 
	 * @param entityType
	 * @return translated entity
	 */
	public String translate(String translation, EntityType entityType);
	
	/**
	 * Translate entity type using default language
	 * 
	 * @param entityType
	 * @return translated entity
	 */
	public String translate(OfflinePlayer player, EntityType entityType);
	
	/**
	 * Return the key for the translation using a material
	 * 
	 * @param material
	 * @return optional of key
	 */
	public Optional<String> getKey(Material material);

	/**
	 * Return the key for the translation using an itemStack
	 * 
	 * @param itemStack
	 * @return optional of key
	 */
	public Optional<String> getKey(ItemStack itemStack);
	
	/**
	 * Return the key for the translation using an entityType
	 * 
	 * @param entityType
	 * @return optional of key
	 */
	public Optional<String> getKey(EntityType entityType);

}

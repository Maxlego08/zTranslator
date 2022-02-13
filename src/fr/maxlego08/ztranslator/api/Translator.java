package fr.maxlego08.ztranslator.api;

import java.util.Optional;

import org.bukkit.Material;

import fr.maxlego08.ztranslator.zcore.utils.storage.Saveable;

public interface Translator extends Saveable{

	public Optional<Translation> getTranslation(String lang);
	
	public String translate(Material material);
	
	public String translate(String translation, Material material);
	
	public Optional<String> getKey(Material material);
	
}

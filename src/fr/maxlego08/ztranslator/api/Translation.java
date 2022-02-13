package fr.maxlego08.ztranslator.api;

import java.util.Optional;

public interface Translation {

	/**
	 * String optional of value using key
	 * 
	 * @param key
	 * @return optional
	 */
	public Optional<String> get(String key);
	
}

package fr.maxlego08.ztranslator.loader;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import fr.maxlego08.ztranslator.api.Translation;

public class ZTranslation implements Translation {

	private Map<String, String> values = new HashMap<String, String>();

	/**
	 * @param values
	 */
	public ZTranslation(Map<String, String> values) {
		super();
		this.values = values;
	}

	/**
	 * @return the values
	 */
	public Map<String, String> getValues() {
		return values;
	}

	/**
	 * @param values
	 *            the values to set
	 */
	public void setValues(Map<String, String> values) {
		this.values = values;
	}

	@Override
	public Optional<String> get(String key) {
		return Optional.ofNullable(this.values.getOrDefault(key, null));
	}

}

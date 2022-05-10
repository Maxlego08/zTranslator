package fr.maxlego08.ztranslator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import fr.maxlego08.ztranslator.api.Translation;
import fr.maxlego08.ztranslator.api.Translator;
import fr.maxlego08.ztranslator.loader.ItemBind;
import fr.maxlego08.ztranslator.loader.ZTranslation;
import fr.maxlego08.ztranslator.save.Config;
import fr.maxlego08.ztranslator.zcore.utils.ZUtils;
import fr.maxlego08.ztranslator.zcore.utils.storage.Persist;

public class TranslatorManager extends ZUtils implements Translator {

	private static List<ItemBind> items = new ArrayList<ItemBind>();
	private final transient TranslatorPlugin plugin;
	private final transient List<String> langNames = new ArrayList<>();
	private final transient Map<String, Translation> translations = new HashMap<String, Translation>();

	/**
	 * @param plugin
	 */
	public TranslatorManager(TranslatorPlugin plugin) {
		super();
		this.plugin = plugin;
	}

	@Override
	public void save(Persist persist) {

	}

	@Override
	public void load(Persist persist) {

		this.translations.clear();

		persist.loadOrSaveDefault(this, TranslatorManager.class, "bind");
		this.saveFiles();
		this.loadTranslations();

	}

	/*
	 * Load tranlations
	 */
	private void loadTranslations() {
		Gson gson = this.plugin.getGson();
		Type listType = new TypeToken<Map<String, String>>() {
		}.getType();

		this.langNames.forEach(name -> {

			String fileName = String.format("langs/%s.json", name);
			File file = new File(this.plugin.getDataFolder(), fileName);

			if (file.exists()) {
				try {

					FileReader fileReader = new FileReader(file);
					Map<String, String> values = gson.fromJson(fileReader, listType);

					ZTranslation translation = new ZTranslation(values);
					this.translations.put(name, translation);

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Load lang files
	 */
	private void saveFiles() {
		this.langNames.clear();
		try {
			URI uri = this.plugin.getClassL().getResource("langs").toURI();
			final Map<String, String> env = new HashMap<>();
			final String[] array = uri.toString().split("!");
			final FileSystem fs = FileSystems.newFileSystem(URI.create(array[0]), env);
			final Path path1 = fs.getPath(array[1]);
			Stream<Path> walk = Files.walk(path1, 1);
			for (Iterator<Path> it = walk.iterator(); it.hasNext();) {
				Path path = it.next();
				String name = path.getFileName().toString();
				if (name.endsWith(".json")) {
					if (!new File(this.plugin.getDataFolder(), "langs/" + name).exists()) {
						this.plugin.saveResource("langs/" + name, false);
					}
					this.langNames.add(name.replace(".json", ""));
				}
			}
			walk.close();
			fs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Optional<Translation> getTranslation(String lang) {
		return Optional.ofNullable(this.translations.getOrDefault(lang, null));
	}

	@Override
	public String translate(Material material) {
		return this.translate(Config.defaultTranslation, material);
	}

	@Override
	public String translate(String lang, Material material) {
		return this.translate(lang, new ItemStack(material));
	}

	@Override
	public Optional<String> getKey(Material material) {
		return this.getKey(new ItemStack(material));
	}

	@Override
	public String translate(ItemStack itemStack) {
		return this.translate(Config.defaultTranslation, itemStack);
	}

	@Override
	public String translate(String lang, ItemStack itemStack) {
		Optional<Translation> optional = this.getTranslation(lang);
		if (optional.isPresent()) {
			Translation translation = optional.get();
			Optional<String> optionalKey = this.getKey(itemStack);
			if (optionalKey.isPresent()) {
				String key = optionalKey.get();
				Optional<String> optionalTranslate = translation.get(key);
				return optionalTranslate.isPresent() ? optionalTranslate.get() : this.name(itemStack);
			}
		}
		return this.name(itemStack);
	}

	@Override
	public Optional<String> getKey(ItemStack itemStack) {
		return items.stream().filter(e -> e.isKeyOf(itemStack)).map(e -> e.getLang()).findFirst();
	}

	@Override
	public String translate(OfflinePlayer player, ItemStack itemStack) {
		return this.translate(itemStack);
	}

	@Override
	public String translate(EntityType entityType) {
		return this.translate(Config.defaultTranslation, entityType);
	}

	@Override
	public String translate(OfflinePlayer player, EntityType entityType) {
		return this.translate(entityType);
	}

	@Override
	public Optional<String> getKey(EntityType entityType) {
		return Optional.of("entity.minecraft."+ entityType.name().toLowerCase());
	}

	@Override
	public String translate(String lang, EntityType entityType) {
		
		Optional<Translation> optional = this.getTranslation(lang);
		if (optional.isPresent()) {
			Translation translation = optional.get();
			Optional<String> optionalKey = this.getKey(entityType);
			if (optionalKey.isPresent()) {
				String key = optionalKey.get();
				Optional<String> optionalTranslate = translation.get(key);
				return optionalTranslate.isPresent() ? optionalTranslate.get() : this.name(entityType.name());
			}
		}
		
		return this.name(entityType.name());
	}

}

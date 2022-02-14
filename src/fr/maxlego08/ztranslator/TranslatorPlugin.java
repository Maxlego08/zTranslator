package fr.maxlego08.ztranslator;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.plugin.ServicePriority;

import fr.maxlego08.ztranslator.api.Translator;
import fr.maxlego08.ztranslator.command.CommandManager;
import fr.maxlego08.ztranslator.command.commands.CommandTranslator;
import fr.maxlego08.ztranslator.inventory.InventoryManager;
import fr.maxlego08.ztranslator.listener.AdapterListener;
import fr.maxlego08.ztranslator.save.Config;
import fr.maxlego08.ztranslator.save.MessageLoader;
import fr.maxlego08.ztranslator.zcore.ZPlugin;
import fr.maxlego08.ztranslator.zcore.utils.plugins.Metrics;
import fr.maxlego08.ztranslator.zcore.utils.plugins.VersionChecker;

/**
 * System to create your plugins very simply Projet:
 * https://github.com/Maxlego08/TemplatePlugin
 * 
 * @author Maxlego08
 *
 */
public class TranslatorPlugin extends ZPlugin {

	private final Translator manager = new TranslatorManager(this);

	@Override
	public void onEnable() {

		this.preEnable();

		if (!new File(this.getDataFolder(), "bind.json").exists()) {
			this.saveResource("bind.json", false);
		}

		this.commandManager = new CommandManager(this);
		this.inventoryManager = new InventoryManager(this);

		this.registerCommand("ztranslator", new CommandTranslator(this));
		
		/* Add Listener */

		this.addListener(new AdapterListener(this));
		this.addListener(this.inventoryManager);

		Bukkit.getServicesManager().register(Translator.class, this.manager, this, ServicePriority.Highest);

		/* Add Saver */
		this.addSave(Config.getInstance());
		this.addSave(new MessageLoader(this));
		this.addSave(this.manager);

		this.getSavers().forEach(saver -> saver.load(this.getPersist()));
						
		VersionChecker checker = new VersionChecker(this, 230);
		checker.useLastVersion();
		
		new Metrics(this, 14307);
		
		this.postEnable();
	}

	@Override
	public void onDisable() {

		this.preDisable();

		this.getSavers().forEach(saver -> saver.save(this.getPersist()));

		this.postDisable();

	}

	public Translator getManager() {
		return manager;
	}

	public ClassLoader getClassL(){
		return this.getClassLoader();
	}
	
}

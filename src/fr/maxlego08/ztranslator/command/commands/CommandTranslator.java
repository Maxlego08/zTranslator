package fr.maxlego08.ztranslator.command.commands;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import fr.maxlego08.ztranslator.TranslatorPlugin;
import fr.maxlego08.ztranslator.api.Translator;
import fr.maxlego08.ztranslator.command.VCommand;
import fr.maxlego08.ztranslator.zcore.enums.Permission;
import fr.maxlego08.ztranslator.zcore.utils.commands.CommandType;

public class CommandTranslator extends VCommand {

	public CommandTranslator(TranslatorPlugin plugin) {
		super(plugin);
		this.setPermission(Permission.ZTRANSLATOR_USE);
		this.addSubCommand(new CommandTranslatorReload(plugin));
	}

	@SuppressWarnings("deprecation")
	@Override
	protected CommandType perform(TranslatorPlugin plugin) {

		
		ItemStack itemStack = new ItemStack(Material.STONE, 1, (byte)5);		
		Translator translator = plugin.getManager();
		
		String value = translator.translate(itemStack);		
		this.sender.sendMessage("§7Traduction§8: §f" + value);
		
		return CommandType.SUCCESS;
	}

}

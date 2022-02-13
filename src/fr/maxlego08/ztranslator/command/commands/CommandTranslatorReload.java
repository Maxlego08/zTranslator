package fr.maxlego08.ztranslator.command.commands;

import fr.maxlego08.ztranslator.TranslatorPlugin;
import fr.maxlego08.ztranslator.command.VCommand;
import fr.maxlego08.ztranslator.zcore.enums.Message;
import fr.maxlego08.ztranslator.zcore.enums.Permission;
import fr.maxlego08.ztranslator.zcore.utils.commands.CommandType;

public class CommandTranslatorReload extends VCommand {

	public CommandTranslatorReload(TranslatorPlugin plugin) {
		super(plugin);
		this.setPermission(Permission.ZTRANSLATOR_RELOAD);
		this.setDescription(Message.DESCRIPTION_RELOAD);
		this.addSubCommand("reload", "rl");
	}

	@Override
	protected CommandType perform(TranslatorPlugin plugin) {

		plugin.getSavers().forEach(e -> e.load(plugin.getPersist()));
		message(this.sender, Message.RELOAD);
		
		return CommandType.SUCCESS;
	}

}

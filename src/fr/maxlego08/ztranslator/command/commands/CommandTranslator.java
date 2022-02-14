package fr.maxlego08.ztranslator.command.commands;

import fr.maxlego08.ztranslator.TranslatorPlugin;
import fr.maxlego08.ztranslator.command.VCommand;
import fr.maxlego08.ztranslator.zcore.enums.Message;
import fr.maxlego08.ztranslator.zcore.enums.Permission;
import fr.maxlego08.ztranslator.zcore.utils.commands.CommandType;

public class CommandTranslator extends VCommand {

	public CommandTranslator(TranslatorPlugin plugin) {
		super(plugin);
		this.setPermission(Permission.ZTRANSLATOR_USE);
		this.addSubCommand(new CommandTranslatorReload(plugin));
		this.addSubCommand(new CommandTranslatorVersion(plugin));
	}

	@Override
	protected CommandType perform(TranslatorPlugin plugin) {

		this.subVCommands.forEach(e -> {
			message(this.sender, Message.COMMAND_SYNTAXE_HELP, "%syntax%", e.getSyntax(), "%description%",
					e.getDescription());
		});

		return CommandType.SUCCESS;
	}

}

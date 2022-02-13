package fr.maxlego08.ztranslator.zcore.utils.commands;

import java.util.function.BiConsumer;

import fr.maxlego08.ztranslator.TranslatorPlugin;
import fr.maxlego08.ztranslator.command.VCommand;

public class ZCommand extends VCommand {

	public ZCommand(TranslatorPlugin plugin) {
		super(plugin);
	}

	private BiConsumer<VCommand, TranslatorPlugin> command;

	@Override
	public CommandType perform(TranslatorPlugin main) {
		
		if (command != null){
			command.accept(this, main);
		}

		return CommandType.SUCCESS;
	}

	public VCommand setCommand(BiConsumer<VCommand, TranslatorPlugin> command) {
		this.command = command;
		return this;
	}

	public VCommand sendHelp(String command) {
		this.command = (cmd, main) -> main.getCommandManager().sendHelp(command, cmd.getSender());
		return this;
	}

}

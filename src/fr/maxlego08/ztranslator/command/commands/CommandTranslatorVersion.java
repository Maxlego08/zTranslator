package fr.maxlego08.ztranslator.command.commands;

import fr.maxlego08.ztranslator.TranslatorPlugin;
import fr.maxlego08.ztranslator.command.VCommand;
import fr.maxlego08.ztranslator.zcore.enums.Message;
import fr.maxlego08.ztranslator.zcore.utils.commands.CommandType;

public class CommandTranslatorVersion extends VCommand {

	public CommandTranslatorVersion(TranslatorPlugin plugin) {
		super(plugin);
		this.setDescription(Message.DESCRIPTION_VERSION);
		this.addSubCommand("version", "ver", "v");
	}

	@Override
	protected CommandType perform(TranslatorPlugin plugin) {

		message(this.sender, "§aVersion du plugin§7: §2" + plugin.getDescription().getVersion());
		message(this.sender, "§aAuteur§7: §2Maxlego08");
		message(this.sender, "§aDiscord§7: §2http://discord.groupez.dev/");
		message(this.sender, "§aDownload now§7: §2https://groupez.dev/resources/230");
		message(this.sender, "§aServeur Minecraft Vote§7: §fhttps://serveur-minecraft-vote.fr/");
		message(this.sender, "§aSponsor§7: §chttps://serveur-minecraft-vote.fr/?ref=345");
		
		return CommandType.SUCCESS;
	}

}

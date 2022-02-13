package fr.maxlego08.ztranslator.zcore.enums;

public enum Permission {
	ZTRANSLATOR_USE, ZTRANSLATOR_RELOAD

	;

	private String permission;

	private Permission() {
		this.permission = this.name().toLowerCase().replace("_", ".");
	}

	public String getPermission() {
		return permission;
	}

}

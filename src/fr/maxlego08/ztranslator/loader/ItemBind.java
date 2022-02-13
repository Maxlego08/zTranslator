package fr.maxlego08.ztranslator.loader;

import org.bukkit.inventory.ItemStack;

public class ItemBind {

	private final Item item;
	private final String lang;
	private final String name;

	/**
	 * @param item
	 * @param lang
	 * @param name
	 */
	public ItemBind(Item item, String lang, String name) {
		super();
		this.item = item;
		this.lang = lang;
		this.name = name;
	}

	/**
	 * @return the item
	 */
	public Item getItem() {
		return item;
	}

	/**
	 * @return the lang
	 */
	public String getLang() {
		return lang;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ItemBind [item=" + item + ", lang=" + lang + ", name=" + name + "]";
	}

	public boolean isKeyOf(ItemStack itemStack) {
		if (this.item == null) {
			System.out.println("NULLED " + this.name + " - " + this.lang);
		}
		return this.item.isKeyOf(itemStack);
	}

}

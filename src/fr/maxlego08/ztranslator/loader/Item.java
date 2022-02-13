package fr.maxlego08.ztranslator.loader;

import org.bukkit.Material;

public class Item {

	private final int id;
	private final String material;
	private final String oldMaterial;
	private final int data;
	private final double version;
	private final int max;

	/**
	 * @param id
	 * @param material
	 * @param oldMaterial
	 * @param data
	 * @param version
	 * @param max
	 */
	public Item(int id, String material, String oldMaterial, int data, double version, int max) {
		super();
		this.id = id;
		this.material = material;
		this.oldMaterial = oldMaterial;
		this.data = data;
		this.version = version;
		this.max = max;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the material
	 */
	public String getMaterial() {
		return material;
	}

	/**
	 * @return the oldMaterial
	 */
	public String getOldMaterial() {
		return oldMaterial;
	}

	/**
	 * @return the data
	 */
	public int getData() {
		return data;
	}

	/**
	 * @return the version
	 */
	public double getVersion() {
		return version;
	}

	/**
	 * @return the max
	 */
	public int getMax() {
		return max;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Item [id=" + id + ", material=" + material + ", oldMaterial=" + oldMaterial + ", data=" + data
				+ ", version=" + version + ", max=" + max + "]";
	}

	public boolean isKeyOf(Material material) {
		return material.name().equals(this.material)
				|| (this.oldMaterial != null && material.name().equals(this.oldMaterial)) && this.data == 0;
	}

}

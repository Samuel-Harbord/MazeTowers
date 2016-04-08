package com.samuel.mazetowers.items;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

import com.samuel.mazetowers.MazeTowers;

public class ItemSpectriteGem extends Item {
	
	public ItemSpectriteGem() {
		super();
		this.addPropertyOverride(new ResourceLocation("time"), MazeTowers.ItemPropertyGetterSpectrite);
	}
}

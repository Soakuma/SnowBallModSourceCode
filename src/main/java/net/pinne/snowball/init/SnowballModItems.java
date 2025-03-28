package net.pinne.snowball.init;

import net.pinne.snowball.item.SleighItemItem;
import net.pinne.snowball.SnowballMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

public class SnowballModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, SnowballMod.MODID);
	public static final RegistryObject<Item> SLEIGH_ITEM = REGISTRY.register("sleigh_item", () -> new SleighItemItem());
	// Start of user code block custom items
	// End of user code block custom items
}


/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.moped.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.core.registries.Registries;

import net.mcreator.moped.world.inventory.MopedGUIMenu;
import net.mcreator.moped.MopedMod;

public class MopedModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, MopedMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<MopedGUIMenu>> MOPED_GUI = REGISTRY.register("moped_gui", () -> IMenuTypeExtension.create(MopedGUIMenu::new));
}

package net.mcreator.moped.procedures;

import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;

import net.mcreator.moped.world.inventory.MopedGUIMenu;
import net.mcreator.moped.init.MopedModItems;

import io.netty.buffer.Unpooled;

public class CopperMopedRightClickedOnEntityProcedure {
	public static void execute(Entity entity, Entity sourceentity, ItemStack itemstack) {
		if (entity == null || sourceentity == null)
			return;
		if (sourceentity instanceof Player _player)
			_player.closeContainer();
		if (itemstack.getItem() == MopedModItems.MOPED_KEY.get()) {
			if (sourceentity instanceof ServerPlayer serverPlayer) {
				NetworkHooks.openScreen(serverPlayer, new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("Copper Moped");
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
						packetBuffer.writeBlockPos(sourceentity.blockPosition());
						packetBuffer.writeByte(0);
						packetBuffer.writeVarInt(entity.getId());
						return new MopedGUIMenu(id, inventory, packetBuffer);
					}
				}, buf -> {
					buf.writeBlockPos(sourceentity.blockPosition());
					buf.writeByte(0);
					buf.writeVarInt(entity.getId());
				});
			}
		} else {
			sourceentity.startRiding(entity);
		}
	}
}

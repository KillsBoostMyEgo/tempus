
package net.mcreator.tempusmod.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemFood;
import net.minecraft.item.Item;
import net.minecraft.item.EnumAction;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.mcreator.tempusmod.procedure.ProcedureClarksSpecialFoodEaten;
import net.mcreator.tempusmod.creativetab.TabTempus;
import net.mcreator.tempusmod.ElementsTempusModMod;

import java.util.Map;
import java.util.HashMap;

@ElementsTempusModMod.ModElement.Tag
public class ItemClarksSpecial extends ElementsTempusModMod.ModElement {
	@GameRegistry.ObjectHolder("tempus_mod:clarks_special")
	public static final Item block = null;
	public ItemClarksSpecial(ElementsTempusModMod instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemFoodCustom());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("tempus_mod:clarks_special", "inventory"));
	}
	public static class ItemFoodCustom extends ItemFood {
		public ItemFoodCustom() {
			super(5, 0.5f, false);
			setUnlocalizedName("clarks_special");
			setRegistryName("clarks_special");
			setCreativeTab(TabTempus.tab);
			setMaxStackSize(1);
		}

		@Override
		public EnumAction getItemUseAction(ItemStack par1ItemStack) {
			return EnumAction.EAT;
		}

		@Override
		protected void onFoodEaten(ItemStack itemStack, World world, EntityPlayer entity) {
			super.onFoodEaten(itemStack, world, entity);
			int x = (int) entity.posX;
			int y = (int) entity.posY;
			int z = (int) entity.posZ;
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				ProcedureClarksSpecialFoodEaten.executeProcedure($_dependencies);
			}
		}
	}
}

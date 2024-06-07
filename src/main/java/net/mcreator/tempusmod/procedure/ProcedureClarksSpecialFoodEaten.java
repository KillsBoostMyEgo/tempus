package net.mcreator.tempusmod.procedure;

import net.minecraft.potion.PotionEffect;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import net.mcreator.tempusmod.potion.PotionDisease;
import net.mcreator.tempusmod.ElementsTempusModMod;

import java.util.Map;

@ElementsTempusModMod.ModElement.Tag
public class ProcedureClarksSpecialFoodEaten extends ElementsTempusModMod.ModElement {
	public ProcedureClarksSpecialFoodEaten(ElementsTempusModMod instance) {
		super(instance, 4);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure ClarksSpecialFoodEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof EntityLivingBase)
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(PotionDisease.potion, (int) 60, (int) 5, (false), (false)));
	}
}

package net.mcreator.tempusmod.procedure;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;

import net.mcreator.tempusmod.ElementsTempusModMod;

import java.util.Map;

@ElementsTempusModMod.ModElement.Tag
public class ProcedureDiseaseOnPotionActiveTick extends ElementsTempusModMod.ModElement {
	public ProcedureDiseaseOnPotionActiveTick(ElementsTempusModMod instance) {
		super(instance, 3);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure DiseaseOnPotionActiveTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.attackEntityFrom(DamageSource.MAGIC, (float) 1);
	}
}

package org.plugins.rpghorses.v_1_14_4;

import com.google.common.collect.Sets;
import net.minecraft.server.v1_14_R1.EntityCreature;
import org.bukkit.craftbukkit.v1_14_R1.entity.CraftEntity;
import org.bukkit.entity.LivingEntity;
import org.plugins.rpghorses.NMS;

import java.lang.reflect.Field;

public class NMSHandler extends NMS {

	@Override
	public void removeBehaviour(LivingEntity entity) {
		EntityCreature creature = (EntityCreature) (((CraftEntity) entity).getHandle());
		try {
			Field d = net.minecraft.server.v1_14_R1.PathfinderGoalSelector.class.getDeclaredField("d");
			d.setAccessible(true);
			d.set(creature.goalSelector, Sets.newLinkedHashSet());
			d.set(creature.targetSelector, Sets.newLinkedHashSet());
		} catch (Exception | Error e) {
			logError(e);
		}
	}
}
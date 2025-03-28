package net.pinne.snowball.procedures;

import net.pinne.snowball.init.SnowballModEntities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

public class SleighItemRightclickedOnBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _level) {
			Entity entityToSpawn = SnowballModEntities.SLEIGH.get().spawn(_level, BlockPos.containing(x, y + 1, z), MobSpawnType.MOB_SUMMONED);
			if (entityToSpawn != null) {
			}
		}
	}
}

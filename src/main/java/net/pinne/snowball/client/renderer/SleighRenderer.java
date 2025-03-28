
package net.pinne.snowball.client.renderer;

import net.pinne.snowball.entity.SleighEntity;
import net.pinne.snowball.client.model.Modelsleigh;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import com.mojang.blaze3d.vertex.PoseStack;

public class SleighRenderer extends MobRenderer<SleighEntity, Modelsleigh<SleighEntity>> {
	public SleighRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelsleigh<SleighEntity>(context.bakeLayer(Modelsleigh.LAYER_LOCATION)), 0.5f);
	}

	@Override
	protected void scale(SleighEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(1.3f, 1.3f, 1.3f);
	}

	@Override
	public ResourceLocation getTextureLocation(SleighEntity entity) {
		return new ResourceLocation("snowball:textures/entities/sleigh.png");
	}
}

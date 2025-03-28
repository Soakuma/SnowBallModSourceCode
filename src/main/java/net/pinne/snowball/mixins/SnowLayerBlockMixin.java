package net.pinne.snowball.mixins;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.SnowLayerBlock;
import net.minecraft.world.level.block.Blocks; // 추가
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SnowLayerBlock.class)
public abstract class SnowLayerBlockMixin {

    @Inject(method = "randomTick", at = @At("HEAD"))
    private void increaseSnowLayers(BlockState state, ServerLevel world, BlockPos pos, RandomSource random, CallbackInfo ci) {
        // 비가 오지 않거나 하늘이 보이지 않으면 종료
        if (!world.isRaining() || !world.canSeeSky(pos.above())) {
            return; 
        }

        // 현재 블록의 눈 층 수 가져오기
        int currentLayers = state.getValue(SnowLayerBlock.LAYERS);
        
        // 눈 층이 8 미만일 때 증가
        if (currentLayers < 8) {
            world.setBlock(pos, state.setValue(SnowLayerBlock.LAYERS, currentLayers + 1), 2);
        } else {
            // 위쪽 블록에 새로운 눈 층 추가
            BlockPos newPos = pos.above();
            BlockState aboveState = world.getBlockState(newPos);
            
            if (aboveState.isAir()) {
                // 공기(AIR) 블록이면 새로 SnowLayerBlock을 배치합니다.
                world.setBlock(newPos, 
                    Blocks.SNOW.defaultBlockState().setValue(SnowLayerBlock.LAYERS, 1), 
                    2);
            } else if (aboveState.getBlock() instanceof SnowLayerBlock) {
                // 위 블록이 SnowLayerBlock일 때만 LAYERS 속성 변경
                int aboveLayers = aboveState.getValue(SnowLayerBlock.LAYERS);
                
                if (aboveLayers < 8) {
                    world.setBlock(newPos, aboveState.setValue(SnowLayerBlock.LAYERS, aboveLayers + 1), 2);
                } else {
                    world.setBlock(newPos.above(), 
                        Blocks.SNOW.defaultBlockState().setValue(SnowLayerBlock.LAYERS, 1), 
                        2);
                }
            }
        }
    }
}


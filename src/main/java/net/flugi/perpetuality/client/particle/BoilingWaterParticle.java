package net.flugi.perpetuality.client.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.flugi.perpetuality.block.ModBlocks;
import net.flugi.perpetuality.block.custom.PotBlock;
import net.minecraft.client.particle.BillboardParticle;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleFactory;
import net.minecraft.client.particle.SpriteProvider;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;


@Environment(EnvType.CLIENT)
public class BoilingWaterParticle extends BillboardParticle {
    BoilingWaterParticle(ClientWorld clientWorld, double d, double e, double f, double g, double h, double i, Sprite sprite) {
        super(clientWorld, d, e, f, sprite);
        this.gravityStrength = -0.025F;
        this.velocityMultiplier = 0.85F;
        this.setBoundingBoxSpacing(0.02F*0, 0.02F*0);
        this.scale = this.scale * (this.random.nextFloat() * 0.25F + 0.2F);
        this.velocityX = 0;
        this.velocityY = (h + (this.random.nextFloat()))*0.2f;
        this.velocityZ = 0;
        this.maxAge = (int)(20.0 / (this.random.nextFloat() * 0.8 + 0.2));
    }

    @Override
    public void tick() {
        BlockPos pos = BlockPos.ofFloored(this.x, this.y, this.z);
        super.tick();
        if (!this.dead && (this.y-pos.getY()>=10.75/16f|| this.world.getBlockState(pos).getBlock()!=ModBlocks.CROCKPOT_BLOCK || this.world.getBlockState(pos).get(PotBlock.LEVEL)>0)) {
            this.markDead();
        }
    }

    @Override
    public BillboardParticle.RenderType getRenderType() {
        return BillboardParticle.RenderType.PARTICLE_ATLAS_OPAQUE;
    }

    @Environment(EnvType.CLIENT)
    public static class Factory implements ParticleFactory<SimpleParticleType> {
        private final SpriteProvider spriteProvider;

        public Factory(SpriteProvider spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        public Particle createParticle(
                SimpleParticleType simpleParticleType, ClientWorld clientWorld, double d, double e, double f, double g, double h, double i, Random random
        ) {
            return new BoilingWaterParticle(clientWorld, d, e, f, g, h, i, this.spriteProvider.getSprite(random));
        }
    }
}
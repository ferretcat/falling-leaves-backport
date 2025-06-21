package de.larsensmods.stl_backport.fabric.client;

import de.larsensmods.stl_backport.particles.STLParticleTypes;
import de.larsensmods.stl_backport.particles.client.FallingLeavesParticle;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;

public final class SpringToLifeModFabricClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        ParticleFactoryRegistry.getInstance().register(STLParticleTypes.TINTED_LEAVES.get(),
                FallingLeavesParticle.TintedLeavesProvider::new);
    }
}

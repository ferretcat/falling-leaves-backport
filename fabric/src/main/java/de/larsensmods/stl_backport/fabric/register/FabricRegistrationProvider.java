package de.larsensmods.stl_backport.fabric.register;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import de.larsensmods.regutil.IRegistrationProvider;
import de.larsensmods.stl_backport.SpringToLifeMod;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;

public class FabricRegistrationProvider implements IRegistrationProvider {

    private final Map<String, Object> overrideKeys = new HashMap<>();

    public void addOverrideKey(String key, Object value) {
        overrideKeys.put(key, value);
    }

    @Override
    public <T extends ParticleOptions> Supplier<ParticleType<T>> registerParticleType(String key,
            Supplier<ParticleType<T>> particleType) {
        ParticleType<T> regParticleType = Registry.register(BuiltInRegistries.PARTICLE_TYPE,
                ResourceLocation.fromNamespaceAndPath(SpringToLifeMod.MOD_ID, key), particleType.get());
        return () -> regParticleType;
    }

    @Override
    public Supplier<SimpleParticleType> registerParticleTypeSimple(String key) {
        SimpleParticleType simpleParticleType = Registry.register(BuiltInRegistries.PARTICLE_TYPE,
                ResourceLocation.fromNamespaceAndPath(SpringToLifeMod.MOD_ID, key), FabricParticleTypes.simple());
        return () -> simpleParticleType;
    }

}

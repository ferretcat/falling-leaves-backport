package de.larsensmods.regutil;

import java.util.function.Supplier;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;

public interface IRegistrationProvider {

    <T extends ParticleOptions> Supplier<ParticleType<T>> registerParticleType(String key,
            Supplier<ParticleType<T>> particleType);

    Supplier<SimpleParticleType> registerParticleTypeSimple(String key);

}

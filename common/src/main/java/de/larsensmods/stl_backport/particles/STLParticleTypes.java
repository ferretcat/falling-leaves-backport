package de.larsensmods.stl_backport.particles;

import java.util.function.Supplier;

import org.jetbrains.annotations.NotNull;

import com.mojang.serialization.MapCodec;

import de.larsensmods.regutil.IRegistrationProvider;
import de.larsensmods.stl_backport.SpringToLifeMod;
import net.minecraft.core.particles.ColorParticleOption;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;

public class STLParticleTypes {

    public static Supplier<ParticleType<ColorParticleOption>> TINTED_LEAVES;

    public static void initParticleTypes(IRegistrationProvider provider) {
        SpringToLifeMod.LOGGER.info("Initializing particle types");

        //noinspection Convert2Diamond
        TINTED_LEAVES = provider.registerParticleType("tinted_leaves",
                () -> new ParticleType<ColorParticleOption>(false) {
                    @Override
                    public @NotNull MapCodec<ColorParticleOption> codec() {
                        return ColorParticleOption.codec(this);
                    }

                    @Override
                    public @NotNull StreamCodec<? super RegistryFriendlyByteBuf, ColorParticleOption> streamCodec() {
                        return ColorParticleOption.streamCodec(this);
                    }
                });

    }

}

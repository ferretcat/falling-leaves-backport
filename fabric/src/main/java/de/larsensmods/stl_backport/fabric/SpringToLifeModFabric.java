package de.larsensmods.stl_backport.fabric;

import de.larsensmods.stl_backport.SpringToLifeMod;
import de.larsensmods.stl_backport.fabric.register.FabricRegistrationProvider;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public final class SpringToLifeModFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        FabricRegistrationProvider registrationProvider = new FabricRegistrationProvider();

        // Run our common setup.
        SpringToLifeMod.init(registrationProvider,
                FabricLoader.getInstance().getEnvironmentType().equals(EnvType.CLIENT));

    }
}

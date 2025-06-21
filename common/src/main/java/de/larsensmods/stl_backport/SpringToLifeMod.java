package de.larsensmods.stl_backport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.larsensmods.regutil.IRegistrationProvider;
import de.larsensmods.stl_backport.particles.STLParticleTypes;
import de.larsensmods.stl_backport.util.ClientColorUtils;
import de.larsensmods.stl_backport.util.ColorUtils;
import de.larsensmods.stl_backport.util.ServerColorUtils;

public final class SpringToLifeMod {

    public static final String MOD_ID = "spring_to_life";

    public static final Logger LOGGER = LoggerFactory.getLogger(SpringToLifeMod.class);

    private static ColorUtils colorUtils;

    public static void init(IRegistrationProvider regProvider, boolean isClient) {
        LOGGER.info("SpringToLifeMod common init");

        if (isClient) {
            colorUtils = new ClientColorUtils();
        } else {
            colorUtils = new ServerColorUtils();
        }

        STLParticleTypes.initParticleTypes(regProvider);

        LOGGER.info("SpringToLifeMod end common init");
    }

    public static ColorUtils getColorUtils() {
        return colorUtils;
    }
}

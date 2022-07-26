package de.chaoscaot.bumpgl;

import de.chaoscaot.bumpgl.modmenu.Config;
import de.chaoscaot.bumpgl.modmenu.ConfigHolder;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public class GLBumpMod implements ModInitializer {
    private static boolean hasClothConfig;

    @Override
    public void onInitialize() {
        FabricLoader.getInstance().getModContainer("cloth-config").ifPresent(modContainer -> {
            AutoConfig.register(Config.class, GsonConfigSerializer::new);
            ConfigHolder.config = AutoConfig.getConfigHolder(Config.class).getConfig();
            hasClothConfig = true;
        });
    }

    public static int getOpenGlMajorVersion() {
        if(hasClothConfig) {
            return ConfigHolder.config.openGlVersion.major;
        } else {
            return 3;
        }
    }

    public static int getOpenGlMinorVersion() {
        if(hasClothConfig) {
            return ConfigHolder.config.openGlVersion.minor;
        } else {
            return 2;
        }
    }
}

package me.zircta.rodcolor;

import com.gitlab.candicey.zenithloader.ZenithLoader;
import com.gitlab.candicey.zenithloader.dependency.Dependencies;
import me.zircta.rodcolor.config.RodColorConfig;
import net.weavemc.loader.api.ModInitializer;

public class Main implements ModInitializer {
    public static RodColorConfig config;

    @Override
    public void preInit() {
        ZenithLoader.INSTANCE.loadDependencies(
                Dependencies.INSTANCE.getConcentra().invoke(
                        "rodcolor"
                )
        );

        config = new RodColorConfig();
    }

}

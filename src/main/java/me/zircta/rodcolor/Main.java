package me.zircta.rodcolor;

import me.zircta.rodcolor.config.ConfigManager;
import net.weavemc.loader.api.ModInitializer;
import net.weavemc.loader.api.command.CommandBus;
import me.zircta.rodcolor.command.RodCommand;

public class Main implements ModInitializer {
    public static ConfigManager config = new ConfigManager();

    @Override
    public void preInit() {
        CommandBus.register(new RodCommand());
    }
}
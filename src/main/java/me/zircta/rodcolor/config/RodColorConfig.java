package me.zircta.rodcolor.config;

import cc.polyfrost.oneconfig.config.Config;
import cc.polyfrost.oneconfig.config.annotations.Color;
import cc.polyfrost.oneconfig.config.core.OneColor;
import cc.polyfrost.oneconfig.config.data.Mod;
import cc.polyfrost.oneconfig.config.data.ModType;

public class RodColorConfig extends Config {
    @Color(name = "Rod color", description = "Allows you to select the color of the rod")
    public OneColor color = new OneColor(0,0,0, 255);

    public RodColorConfig() {
        super(new Mod("Rod Color", ModType.PVP), "rod-color.json");
        this.initialize();
    }
}

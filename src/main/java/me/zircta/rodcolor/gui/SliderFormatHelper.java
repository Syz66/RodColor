package me.zircta.rodcolor.gui;

import net.minecraft.client.gui.GuiSlider.FormatHelper;

public class SliderFormatHelper implements FormatHelper {
    @Override
    public String getText(int id, String name, float value) {
        return name + ": " + (int) value;
    }
}

package me.zircta.rodcolor.gui;

import me.zircta.rodcolor.Main;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSlider;
import net.minecraft.util.EnumChatFormatting;

import java.awt.*;

public class ColorGUI extends GuiScreen {

    private final GuiSlider sliderRed = new GuiSlider(new SliderResponder(), 2, this.width / 2 - 70, this.height / 2 - 80, "Red", 0, 255, Main.config.getRed(), new SliderFormatHelper());
    private final GuiSlider sliderGreen = new GuiSlider(new SliderResponder(), 3, this.width / 2 - 70, this.height / 2 - 58, "Green", 0, 255, Main.config.getGreen(), new SliderFormatHelper());
    private final GuiSlider sliderBlue = new GuiSlider(new SliderResponder(), 4, this.width / 2 - 70, this.height / 2 - 36, "Blue", 0, 255, Main.config.getBlue(), new SliderFormatHelper());
    private final GuiButton buttonChroma = new GuiButton(5, this.width / 2 - 70, this.height / 2 + 8, 150, 20, "Chroma: " + (!Main.config.getChroma() ? EnumChatFormatting.RED + "Disabled" : EnumChatFormatting.GREEN + "Enabled"));

    @Override
    public void initGui() {
        this.buttonList.clear();
        sliderRed.yPosition = this.height / 2 - 80;
        sliderGreen.yPosition = this.height / 2 - 58;
        sliderBlue.yPosition = this.height / 2 - 36;
        buttonChroma.yPosition = this.height / 2 - 14;
        super.buttonList.add(sliderRed);
        super.buttonList.add(sliderGreen);
        super.buttonList.add(sliderBlue);
        super.buttonList.add(buttonChroma);
        buttonList.forEach(b -> b.xPosition = this.width / 2 - 70);
    }

    @Override
    public void drawScreen(final int mouseX, final int mouseY, final float partialTicks) {
        try {
            this.drawDefaultBackground();
        } catch (Exception ignored) {
        }
        int x = this.width / 2 - 70;
        int y = this.height / 2 + 15;
        long dif = (x * 10) - (y * 10);
        long color = System.currentTimeMillis() - dif;
        float ff = 2000.0F;
        int i = Color.HSBtoRGB((float) (color % (int) ff) / ff, 0.8F, 0.8F);
        if (Main.config.getChroma())
            drawRect(x - 30, y + 22, x + 180, y + 8, i);
        else
            drawRect(x - 30, y + 22, x + 180, y + 8, new Color(Main.config.getRed(), Main.config.getGreen(), Main.config.getBlue(), 255).getRGB());
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public void actionPerformed(final GuiButton button) {
        switch (button.id) {
            case 2: {
                Main.config.setRed(getSliderValue(sliderRed));
                break;
            }
            case 3: {
                Main.config.setGreen(getSliderValue(sliderGreen));
                break;
            }
            case 4: {
                Main.config.setBlue(getSliderValue(sliderBlue));
                break;
            }
            case 5: {
                Main.config.setChroma(!Main.config.getChroma());
                button.displayString = "Chroma: " + (!Main.config.getChroma() ? EnumChatFormatting.RED + "Disabled" : EnumChatFormatting.GREEN + "Enabled");
            }
        }
    }

    @Override
    public void mouseClickMove(final int mouseX, final int mouseY, final int clickedMouseButton, final long timeSinceLastClick) {
        Main.config.setRed(getSliderValue(sliderRed));
        Main.config.setGreen(getSliderValue(sliderGreen));
        Main.config.setBlue(getSliderValue(sliderBlue));
    }

    @Override
    public void onGuiClosed() {
        Main.config.saveConfig();
    }

    private int getSliderValue(GuiSlider slider) {
        return (int) slider.func_175220_c();
    }

}


package me.zircta.rodcolor.command;

import me.zircta.rodcolor.gui.ColorGUI;
import net.minecraft.client.Minecraft;
import net.weavemc.loader.api.command.Command;
import org.jetbrains.annotations.NotNull;

import java.util.Timer;
import java.util.TimerTask;

public class RodCommand extends Command {
    public RodCommand() {
        super("rodcolor");
    }

    @Override
    public void handle(@NotNull String[] args) {
        new Timer().schedule(new TimerTask() {
            @Override public void run() {
                Minecraft.getMinecraft().displayGuiScreen(new ColorGUI());
            }
        }, 100);
    }
}

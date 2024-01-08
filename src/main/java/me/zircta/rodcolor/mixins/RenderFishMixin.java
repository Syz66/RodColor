package me.zircta.rodcolor.mixins;

import me.zircta.rodcolor.Main;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.RenderFish;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.awt.*;

@Mixin(RenderFish.class)
public class RenderFishMixin {
    @Redirect(method = "doRender(Lnet/minecraft/entity/projectile/EntityFishHook;DDDFF)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/GlStateManager;disableLighting()V"))
    public void enableAlpha() {
        GlStateManager.disableLighting();
        GlStateManager.enableAlpha();
    }

    @Redirect(method = "doRender(Lnet/minecraft/entity/projectile/EntityFishHook;DDDFF)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/WorldRenderer;color(IIII)Lnet/minecraft/client/renderer/WorldRenderer;"))
    public WorldRenderer changeColors(WorldRenderer instance, int r, int g, int b, int a) {
        Color color = Main.config.color.toJavaColor();
        return instance.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
    }
}

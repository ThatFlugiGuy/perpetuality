package net.flugi.perpetuality.client.hud;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.hud.VanillaHudElements;
import net.flugi.perpetuality.Perpetuality;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.util.Identifier;

/*public class UncannyHud implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        HudElementRegistry.attachElementBefore(VanillaHudElements.CHAT, Identifier.of(Perpetuality.MOD_ID, "unccanny_hud"), UncannyHud::render);
    }

    private static void render(DrawContext drawContext) {

        int screenWidth = drawContext.getScaledWindowWidth();
        int screenHeight = drawContext.getScaledWindowHeight();
        Identifier texture = Identifier.of(Perpetuality.MOD_ID, "textures/uncanny.png");
        drawContext.drawTexture(RenderPipelines.GUI_TEXTURED, texture, 0, 0, 0, 0, screenWidth, screenHeight,screenWidth,screenHeight);

    }
}*/

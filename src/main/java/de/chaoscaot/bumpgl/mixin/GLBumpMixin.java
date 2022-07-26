package de.chaoscaot.bumpgl.mixin;

import de.chaoscaot.bumpgl.GLBumpMod;
import net.minecraft.client.util.Window;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Map;

@Mixin(Window.class)
public class GLBumpMixin {
    private static final Map<Integer, Integer> WINDOW_HINTS_OVERRIDE =
            Map.of(GLFW.GLFW_CONTEXT_VERSION_MAJOR, GLBumpMod.getOpenGlMajorVersion(), GLFW.GLFW_CONTEXT_VERSION_MINOR, GLBumpMod.getOpenGlMinorVersion());

    @Redirect(method = "<init>", at = @At(value = "INVOKE", target = "Lorg/lwjgl/glfw/GLFW;glfwWindowHint(II)V", remap = false))
    private void windowHintOverride(int hint, int value) {
        GLFW.glfwWindowHint(hint, WINDOW_HINTS_OVERRIDE.getOrDefault(hint, value));
    }
}

package namechanger.mixins;

import namechanger.NameChanger;
import net.minecraft.client.gui.FontRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(FontRenderer.class)
public class MixinFontRenderer {
    @ModifyVariable(method = "renderStringAtPos", at = @At("HEAD"), argsOnly = true)
    private String renderStringAtPos(String text) {
        if (text == null) return null;
        return NameChanger.Companion.replaceString(text);
    }

    @ModifyVariable(method = "getStringWidth", at = @At("HEAD"), argsOnly = true)
    private String getStringWidth(String text) {
        if (text == null) return null;
        return NameChanger.Companion.replaceString(text);
    }
}

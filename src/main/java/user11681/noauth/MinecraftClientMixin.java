package user11681.noauth;

import com.mojang.authlib.minecraft.OfflineSocialInteractions;
import com.mojang.authlib.minecraft.SocialInteractionsService;
import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.RunArgs;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(MinecraftClient.class)
abstract class MinecraftClientMixin {
    @Redirect(method = "<init>",
              at = @At(value = "INVOKE",
                       target = "Lnet/minecraft/client/MinecraftClient;method_31382(Lcom/mojang/authlib/yggdrasil/YggdrasilAuthenticationService;Lnet/minecraft/client/RunArgs;)Lcom/mojang/authlib/minecraft/SocialInteractionsService;"))
    public SocialInteractionsService yeetAuthentication(final MinecraftClient client, final YggdrasilAuthenticationService yggdrasilAuthenticationService, final RunArgs runArgs) {
        return new OfflineSocialInteractions();
    }
}

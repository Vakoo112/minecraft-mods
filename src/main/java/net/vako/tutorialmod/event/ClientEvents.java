package net.vako.tutorialmod.event;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.vako.tutorialmod.TutorialMod;
import net.vako.tutorialmod.client.ThirstHudOverlay;
import net.vako.tutorialmod.networking.ModMessages;
import net.vako.tutorialmod.networking.packet.DrinkWaterC2SPacket;
import net.vako.tutorialmod.networking.packet.ExampleC2SPacket;
import net.vako.tutorialmod.util.KeyBinding;

public class ClientEvents {

    @Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents{
        @SubscribeEvent
        public static void onKeyRegisterMethod(RegisterKeyMappingsEvent event){
            event.register(KeyBinding.DRINKING_KEY);
        }
        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event){
             if(KeyBinding.DRINKING_KEY.consumeClick()){
                 Minecraft.getInstance().player.sendSystemMessage(Component.literal("Pressed a Key!"));
                 ModMessages.sendToServer(new DrinkWaterC2SPacket());
             }
        }
    }
    @Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents{
        @SubscribeEvent
        public static void onKeyRegisterMethod(RegisterKeyMappingsEvent event){
            event.register(KeyBinding.DRINKING_KEY);
        }
        @SubscribeEvent
        public static void registerGuiOverlays(RegisterGuiOverlaysEvent event) {
            event.registerAboveAll("thirst", ThirstHudOverlay.HUD_THIRST);
        }
    }
}

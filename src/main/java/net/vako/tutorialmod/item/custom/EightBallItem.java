package net.vako.tutorialmod.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class EightBallItem  extends Item {

    public EightBallItem(Properties properties){
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        if(!level.isClientSide() && interactionHand == InteractionHand.MAIN_HAND){
            outPutRandomNumber(player);
            player.getCooldowns().addCooldown(this, 20);
            getRandomNumber();


        }

        return super.use(level, player, interactionHand);
    }

        @Override
        public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> components, TooltipFlag tooltipFlag) {
            if(Screen.hasShiftDown()){
                components.add(Component.literal("RightClick to get a random number").withStyle(ChatFormatting.YELLOW));
            }else {
                components.add(Component.literal("Press shift for info").withStyle(ChatFormatting.BLACK));
            }


            super.appendHoverText(itemStack, level, components, tooltipFlag);
        }

    private void outPutRandomNumber(Player player){
        player.sendSystemMessage(Component.literal("You Number Is" + getRandomNumber()));
    }

    private int getRandomNumber(){
        return RandomSource.createNewThreadLocalInstance().nextInt(10);
    }
}

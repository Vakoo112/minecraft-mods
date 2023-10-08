package net.vako.tutorialmod.item;


import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.vako.tutorialmod.TutorialMod;
import net.vako.tutorialmod.item.custom.EightBallItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

  public static final RegistryObject<Item> ZIRCON = ITEMS.register("redron",()-> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> RAW_ZIRCON = ITEMS.register("raw_redron",()-> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> ETHERIUM = ITEMS.register("etherium",()-> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> EIGHT_BALL = ITEMS.register("eight_ball",()-> new EightBallItem
            (new Item.Properties().tab(CreativeModeTab.TAB_MISC).stacksTo(1)));
    public static void Register(IEventBus event){
        ITEMS.register(event);
    }
}

package net.vako.tutorialmod.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.vako.tutorialmod.TutorialMod;
import net.vako.tutorialmod.block.custom.JumpyBlock;
import net.vako.tutorialmod.block.custom.RedronLampBlock;
import net.vako.tutorialmod.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
     public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);



    public static final RegistryObject<Block> REDRONLAMP_BLOCK = registerBlockMethod("redronlamp_block",
            () -> new RedronLampBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops()
                    .strength(6f).color(MaterialColor.COLOR_RED).lightLevel(state -> state.getValue(RedronLampBlock.LIT) ? 15 : 0)
                    .requiresCorrectToolForDrops()), CreativeModeTab.TAB_MISC );

    public static final RegistryObject<Block> HIGHJUMP_BLOCK = registerBlockMethod("highjump_block",
            ()-> new JumpyBlock(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops()), CreativeModeTab.TAB_MISC );

     private static <T extends Block>RegistryObject<T> registerBlockMethod(String name, Supplier<T> block, CreativeModeTab tab){
         RegistryObject<T> returnThing = BLOCKS.register(name, block);
         registerBlockItem(name,returnThing,tab);
         return returnThing;
     }

     private static<T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab ){
         return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
     }



     public static void register(IEventBus event){
         BLOCKS.register(event);
    }
}

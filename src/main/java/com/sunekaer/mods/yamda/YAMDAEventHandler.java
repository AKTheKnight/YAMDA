package com.sunekaer.mods.yamda;

import com.sunekaer.mods.yamda.block.BlockPortal;
import com.sunekaer.mods.yamda.block.YAMDABlocks;
import com.sunekaer.mods.yamda.item.YAMDAItems;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = YAMDA.MOD_ID)
public class YAMDAEventHandler {
    private static Block withName(Block block, String name)
    {
        block.setCreativeTab(YAMDA.TAB);
        block.setRegistryName(name);
        block.setTranslationKey(YAMDA.MOD_ID + "." + name);
        return block;
    }

    private static Item withName(Item item, String name)
    {
        item.setCreativeTab(YAMDA.TAB);
        item.setRegistryName(name);
        item.setTranslationKey(YAMDA.MOD_ID + "." + name);
        return item;
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event)
    {
        event.getRegistry().register(withName(new BlockPortal(), "portal"));

    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        event.getRegistry().register(new ItemBlock(YAMDABlocks.PORTAL).setRegistryName("portal"));
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event)
    {
        ModelLoader.setCustomModelResourceLocation(YAMDAItems.PORTAL, 0, new ModelResourceLocation(YAMDAItems.PORTAL.getRegistryName(), "normal"));

    }
}

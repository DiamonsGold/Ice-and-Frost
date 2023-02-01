package fr.iceandfire;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.init.Items;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import cpw.mods.fml.common.registry.GameRegistry;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLInitializationEvent;

@Mod(modid = Main.MODID, version = Main.VERSION)
public class Main
{
    public static final String MODID = "iceandfrost";
    public static final String VERSION = "1.0";

    public static Item itemFrozenRottenFlesh;
    public static Block blockFrozenCobblestone;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        itemFrozenRottenFlesh = new ItemFood(1, 0.1f, false)
                .setUnlocalizedName("ItemFrozenRottenFlesh")
                .setTextureName("iceandfrost:frozen_rotten_flesh")
                .setCreativeTab(tabIceAndFrost);
        blockFrozenCobblestone = new BlockFrozenCobblestone(Material.rock)
                .setBlockName("BlockFrozenCobblestone")
                .setBlockTextureName("iceandfrost:frozen_cobblestone")
                .setCreativeTab(tabIceAndFrost);

        GameRegistry.registerItem(
                itemFrozenRottenFlesh,
                itemFrozenRottenFlesh.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(
                blockFrozenCobblestone,
                blockFrozenCobblestone.getUnlocalizedName().substring(5));

        GameRegistry.addSmelting(
                itemFrozenRottenFlesh,
                new ItemStack(Items.rotten_flesh),
                0.1f);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        GameRegistry.addRecipe(
                new ItemStack(blockFrozenCobblestone),
                " S ", "SCS", " S ", 'C', Blocks.cobblestone, 'S', Items.snowball);
    }

    public static CreativeTabs tabIceAndFrost = new CreativeTabs("tabIceAndFrost")
    {
        @Override
        public Item getTabIconItem()
        {
            return itemFrozenRottenFlesh;
        }
    };
}

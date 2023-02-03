package fr.iceandfrost;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;

import fr.iceandfrost.item.ItemFrostPickaxe;
import fr.iceandfrost.item.ItemFrostSword;
import fr.iceandfrost.item.ItemFrostAxe;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.init.Items;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLInitializationEvent;

@Mod(modid = Main.MODID, version = Main.VERSION)
public class Main
{
    public static final String MODID = "iceandfrost";
    public static final String VERSION = "1.0";

    public static Item itemFrozenRottenFlesh;
    public static Block blockFrozenCobblestone;

    public static Item itemFrostPickaxe;
    public static Item itemFrostSword;
    public static Item itemFrostAxe;


    public static final Item.ToolMaterial frostToolMaterial = EnumHelper.addToolMaterial(
            "frostToolMaterial",
            4,
            2031,
            10.0f,
            4.0f,
            14);

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

        itemFrostPickaxe = new ItemFrostPickaxe(frostToolMaterial)
                .setUnlocalizedName("ItemFrostPickaxe")
                .setTextureName("iceandfrost:frost_pickaxe")
                .setCreativeTab(tabIceAndFrost);
        itemFrostSword = new ItemFrostSword(frostToolMaterial)
                .setUnlocalizedName("ItemFrostSword")
                .setTextureName("iceandfrost:frost_sword")
                .setCreativeTab(tabIceAndFrost);
        itemFrostAxe = new ItemFrostAxe(frostToolMaterial)
                .setUnlocalizedName("ItemFrostAxe")
                .setTextureName("iceandfrost:frost_axe")
                .setCreativeTab(tabIceAndFrost);

        GameRegistry.registerItem(
                itemFrozenRottenFlesh,
                itemFrozenRottenFlesh.getUnlocalizedName().substring(5));

        GameRegistry.registerBlock(
                blockFrozenCobblestone,
                blockFrozenCobblestone.getUnlocalizedName().substring(5));

        GameRegistry.registerItem(
                itemFrostPickaxe,
                itemFrostPickaxe.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(
                itemFrostSword,
                itemFrostSword.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(
                itemFrostAxe,
                itemFrostAxe.getUnlocalizedName().substring(5));

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

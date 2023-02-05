package fr.iceandfrost.item;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemFrostHammer extends ItemPickaxe
{
    public ItemFrostHammer(ToolMaterial material)
    {
        super(material);
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World world, Block block,
                                    int x, int y, int z, EntityLivingBase entityLiving)
    {
        System.out.println("onBlockDestroyed");

        for(int ix = -1; ix < 2; ++ix)
        {
            for (int iz = -1; iz < 2; ++iz)
            {
                world.func_147480_a(x + ix, y, z + iz, true);
                stack.damageItem(9, entityLiving);
            }
        }
        return false;
    }
}

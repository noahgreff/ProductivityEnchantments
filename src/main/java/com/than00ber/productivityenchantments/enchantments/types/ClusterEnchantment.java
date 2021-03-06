package com.than00ber.productivityenchantments.enchantments.types;

import com.than00ber.productivityenchantments.enchantments.CarverEnchantmentBase;
import com.than00ber.productivityenchantments.IValidatorCallback;
import net.minecraft.block.BlockState;
import net.minecraft.block.OreBlock;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.ToolType;

public class ClusterEnchantment extends CarverEnchantmentBase {

    public ClusterEnchantment() {
        super(Rarity.RARE, ToolType.PICKAXE);
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public int getMaxEffectiveRadius(int level) {
        return 5;
    }

    @Override
    public boolean canApplyTogether(Enchantment enchantment) {
        return super.canApplyTogether(enchantment) || enchantment instanceof DiggingEnchantment;
    }

    @Override
    public boolean isBlockValid(BlockState state, World world, BlockPos pos, ItemStack stack, ToolType type) {
        boolean isOre = state.isIn(Tags.Blocks.ORES) || state.getBlock() instanceof OreBlock;
        return IValidatorCallback.defaultCheck(state, stack, type) && isOre;
    }
}

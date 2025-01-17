package net.joefoxe.hexerei.tileentity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ModSignBlockEntity extends SignBlockEntity {
    public ModSignBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModTileEntities.SIGN_TILE.get(), pPos, pBlockState);
    }

    @Override
    public BlockEntityType<?> getType() {
        return ModTileEntities.SIGN_TILE.get();
    }
}
package com.samuel.mazetowers.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.samuel.mazetowers.MazeTowers;
import com.samuel.mazetowers.tileentities.TileEntityMazeTowerThreshold;

public class BlockMazeTowerThreshold extends BlockContainer {

	public BlockMazeTowerThreshold() {
		super(MazeTowers.solidCircuits);
		this.setBlockBounds(0F, 0.0F, 0F, 0F, 0F, 0F);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn,
		int meta) {
		return new TileEntityMazeTowerThreshold();
	}

	@Override
	/**
	 * Used to determine ambient occlusion and culling when rebuilding chunks for render
	 */
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean isFullCube() {
		return false;
	}

	@Override
	/**
	 * The type of render function called. 3 for standard block models, 2 for TESR's, 1 for liquids, -1 is no render
	 */
	public int getRenderType() {
		return -1;
	}
}
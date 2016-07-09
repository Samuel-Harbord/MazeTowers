package com.samuel.mazetowers.eventhandlers;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.minecraft.block.BlockDoor;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.EnumFacing.Axis;
import net.minecraft.util.EnumFacing.AxisDirection;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.WorldServer;
import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.event.world.BlockEvent.NeighborNotifyEvent;
import net.minecraftforge.event.world.ExplosionEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import com.samuel.mazetowers.MazeTowers;
import com.samuel.mazetowers.etc.MTHelper;
import com.samuel.mazetowers.init.ModBlocks;
import com.samuel.mazetowers.world.WorldGenMazeTowers;
import com.samuel.mazetowers.world.WorldGenMazeTowers.MazeTowerBase;
import com.samuel.mazetowers.world.WorldGenMazeTowers.MiniTower;

public class MazeTowersGeneralEventHandler {

	@SubscribeEvent
	public void OnHarvestDrops(HarvestDropsEvent e) {
		if (e.getHarvester() != null) {
			final int dimId = e.getWorld().provider
				.getDimension() + 1;
			Chunk chunk = e.getWorld()
				.getChunkFromBlockCoords(e.getPos());
			if (MTHelper.getIsMazeTowerPos(dimId - 1, e.getPos())) {
				MazeTowerBase tower = MazeTowers.mazeTowers
					.getTowerAtCoords(e.getWorld(),
						chunk.xPosition, chunk.zPosition);
				BitSet[][] blockBreakabilityData = tower
					.getBlockBreakabilityData();
				try {
					int[] coords = tower
						.getCoordsFromPos(e.getPos());
					if (coords[0] == -6)
						coords[0] = blockBreakabilityData.length - 1;
					if (coords[0] >= 0
						&& coords[0] < blockBreakabilityData.length
						&& !blockBreakabilityData[coords[0]][coords[1]]
							.get(coords[2]))
						e.getDrops().clear();
				} catch (ArrayIndexOutOfBoundsException e_) {
					e_ = null;
				}
			}
		}
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onBlockNeighbourNotify(NeighborNotifyEvent e) {
		if (e.getState().getBlock().canProvidePower(e.getState())) {
    		for (EnumFacing side : e.getNotifiedSides()) {
        		if (e.getState().getBlock().getWeakPower(e.getState(), e.getWorld(), e.getPos(), side) != 0) {
        			BlockPos pos = e.getPos().offset(side);
        			IBlockState state = e.getWorld().getBlockState(pos);
            		if (state.getBlock() instanceof BlockDoor) {
            			final int addToPos;
            			final boolean isXAxis, isFront, isLockedFront, isLockedBack;
            			EnumFacing doorDir;
            			BlockPos topHalfPos, lockPos;
            			if (state.getValue(BlockDoor.HALF) == BlockDoor.EnumDoorHalf.LOWER) {
            				topHalfPos = pos.up();
            				doorDir = state.getValue(BlockDoor.FACING);
            			} else {
            				topHalfPos = pos;
            				doorDir = e.getWorld().getBlockState(pos.down()).getValue(BlockDoor.FACING);
            			}
            			addToPos = (doorDir.getAxisDirection() == AxisDirection.POSITIVE ? 1 : -1);
            			isXAxis = doorDir.getAxis() == Axis.X;
            			isFront = isXAxis ? e.getPos().getX() == pos.getX() + addToPos :
            				e.getPos().getZ() == pos.getZ() + addToPos;
            				
            			isLockedFront = e.getWorld().getBlockState(lockPos = topHalfPos.offset(doorDir))
            				.getBlock() == ModBlocks.lock;
            			isLockedBack = !isLockedFront && e.getWorld().getBlockState(
            				lockPos = topHalfPos.offset(doorDir.getOpposite())).getBlock() == ModBlocks.lock;
            			if (isLockedFront || isLockedBack/*(isLockedFront && isFront) || (isLockedBack && !isFront)*/) {
            				e.setCanceled(true);
            				break;
            			}
            		}
        		}
    		}
		}
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void replaceVanillaVillagers(LivingSpawnEvent event)
	{
	    /*if (event.entity instanceof EntityVillager && !MTUtils.getIsMazeTowerPos(event.world.provider.getDimension(),
	    	new BlockPos(event.x, event.y, event.z)) && event.world.rand.nextInt(32) == 0)
	    {
	        EntitySpecialVillager specialVillager = new EntitySpecialVillager(event.entity.worldObj);
	        specialVillager.setLocationAndAngles(event.entity.posX, event.entity.posY, event.entity.posZ,
	        	event.entity.rotationPitch, event.entity.rotationYaw);
	        specialVillager.setIsWillingToTrade(true);
	        event.entity.worldObj.spawnEntityInWorld(specialVillager);
	        event.entity.setDead();
	    }*/
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onFOVUpdateEvent(FOVUpdateEvent e) {
		if (e.getEntity() != null
			&& e.getEntity().getHeldItemMainhand() != null
			&& e.getEntity() instanceof EntityPlayer
			&& e.getEntity().getHeldItemMainhand().getItem() == MazeTowers.ItemExplosiveBow) {
			EntityPlayer player = e.getEntity();
			int i = player.getItemInUseCount();
			float f1 = i / 20.0F;

			if (f1 > 1.0F) {
				f1 = 1.0F;
			} else {
				f1 *= f1;
			}

			e.setNewfov(e.getFov() * (1.0F - f1 * 0.15F));
		}
	}
}

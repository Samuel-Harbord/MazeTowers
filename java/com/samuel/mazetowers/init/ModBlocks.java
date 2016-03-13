package com.samuel.mazetowers.init;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.samuel.mazetowers.MazeTowers;
import com.samuel.mazetowers.blocks.*;
import com.samuel.mazetowers.items.ItemBlockLock;
import com.samuel.mazetowers.items.ItemBlockRedstoneClock;

public class ModBlocks {

	public static BlockItemScanner itemScanner;
	public static BlockItemScannerGold itemScannerGold;
	public static BlockMazeTowerThreshold mazeTowerThreshold;
	public static BlockMemoryPistonBase memoryPiston;
	public static BlockMemoryPistonBaseOff memoryPistonOff;
	public static BlockMemoryPistonExtension memoryPistonHead;
	public static BlockMemoryPistonExtensionOff memoryPistonHeadOff;
	public static BlockMemoryPistonMoving memoryPistonExtension;
	public static BlockMemoryPistonMovingOff memoryPistonExtensionOff;
	public static BlockMineralChest mineralChestIron;
	public static BlockMineralChest mineralChestGold;
	public static BlockMineralChest mineralChestDiamond;
	public static BlockExtraStairs packedIceStairs;
	public static BlockExtraStairs prismarineBrickStairs;
	public static BlockExtraStairs endStoneStairs;
	public static BlockExtraStairs obsidianStairs;
	public static BlockExtraStairs bedrockStairs;
	public static BlockExtraWall sandstoneWall;
	public static BlockExtraWall redSandstoneWall;
	public static BlockExtraWall stoneBrickWall;
	public static BlockExtraWall mossyStoneBrickWall;
	public static BlockExtraWall packedIceWall;
	public static BlockExtraWall prismarineBrickWall;
	public static BlockExtraWall quartzWall;
	public static BlockExtraWall endStoneWall;
	public static BlockExtraWall purpurWall;
	public static BlockExtraWall obsidianWall;
	public static BlockExtraWall bedrockWall;
	public static BlockHiddenButton hiddenButton;
	public static BlockHiddenPressurePlateWeighted hiddenPressurePlateWeighted;
	public static BlockExtraDoor resistantDoorPrismarine;
	public static BlockExtraDoor resistantDoorQuartz;
	public static BlockExtraDoor resistantDoorEndStone;
	public static BlockExtraDoor resistantDoorPurpur;
	public static BlockExtraDoor resistantDoorObsidian;
	public static BlockExtraDoor resistantDoorBedrock;
	public static BlockLock lock;
	public static BlockRedstoneClock redstone_clock;
	public static BlockRedstoneClock redstone_clock_inverted;
	public static BlockExplosiveCreeperSkull explosiveCreeperSkull;
	public static BlockSpecialMobSpawner specialMobSpawner;
	public static BlockVendorSpawner vendorSpawner;
	public static BlockChaoticSludge chaoticSludge;

	public static void createBlocks() {
		GameRegistry.registerBlock(
			hiddenPressurePlateWeighted = MazeTowers.BlockHiddenPressurePlateWeighted,
			"hidden_heavy_pressure_plate");
		GameRegistry.registerBlock(itemScanner = MazeTowers.BlockItemScanner,
			"item_scanner");
		GameRegistry.registerBlock(itemScannerGold = MazeTowers.BlockItemScannerGold,
			"item_scanner_gold");
		GameRegistry.registerBlock(mazeTowerThreshold = MazeTowers.BlockMazeTowerThreshold,
			null, "maze_tower_threshold");
		GameRegistry.registerBlock(memoryPiston = MazeTowers.BlockMemoryPiston,
			"memory_piston");
		GameRegistry.registerBlock(memoryPistonOff = MazeTowers.BlockMemoryPistonOff,
			"memory_piston_off");
		GameRegistry.registerBlock(memoryPistonHead = MazeTowers.BlockMemoryPistonHead, null,
			"memory_piston_head");
		GameRegistry.registerBlock(memoryPistonHeadOff =
			MazeTowers.BlockMemoryPistonHeadOff, null, "memory_piston_head_off");
		GameRegistry.registerBlock(
			memoryPistonExtension = MazeTowers.BlockMemoryPistonExtension, null,
			"memory_piston_extension");
		GameRegistry.registerBlock(memoryPistonExtensionOff =
			MazeTowers.BlockMemoryPistonExtensionOff, null, "memory_piston_extension_off");
		GameRegistry.registerBlock(packedIceStairs = MazeTowers.BlockPackedIceStairs,
			"packed_ice_stairs");
		GameRegistry.registerBlock(prismarineBrickStairs = MazeTowers.BlockPrismarineBrickStairs,
			"prismarine_brick_stairs");
		GameRegistry.registerBlock(endStoneStairs = MazeTowers.BlockEndStoneStairs,
			"end_stone_stairs");
		GameRegistry.registerBlock(obsidianStairs = MazeTowers.BlockObsidianStairs,
			"obsidian_stairs");
		GameRegistry.registerBlock(bedrockStairs = MazeTowers.BlockBedrockStairs,
			"bedrock_stairs");
		GameRegistry.registerBlock(sandstoneWall = MazeTowers.BlockSandstoneWall,
			"sandstone_wall");
		GameRegistry.registerBlock(redSandstoneWall = MazeTowers.BlockRedSandstoneWall,
			"red_sandstone_wall");
		GameRegistry.registerBlock(stoneBrickWall = MazeTowers.BlockStoneBrickWall,
			"stone_brick_wall");
		GameRegistry.registerBlock(mossyStoneBrickWall = MazeTowers.BlockMossyStoneBrickWall,
			"mossy_stone_brick_wall");
		GameRegistry.registerBlock(packedIceWall = MazeTowers.BlockPackedIceWall,
			"packed_ice_wall");
		GameRegistry.registerBlock(prismarineBrickWall = MazeTowers.BlockPrismarineBrickWall,
			"prismarine_brick_wall");
		GameRegistry.registerBlock(quartzWall = MazeTowers.BlockQuartzWall, "quartz_wall");
		GameRegistry.registerBlock(endStoneWall = MazeTowers.BlockEndStoneWall,
			"end_stone_wall");
		GameRegistry.registerBlock(purpurWall = MazeTowers.BlockPurpurWall, "purpur_wall");
		GameRegistry.registerBlock(obsidianWall = MazeTowers.BlockObsidianWall,
			"obsidian_wall");
		GameRegistry.registerBlock(bedrockWall = MazeTowers.BlockBedrockWall,
			"bedrock_wall");
		GameRegistry.registerBlock(mineralChestIron = MazeTowers.BlockIronChest,
			"iron_chest");
		GameRegistry.registerBlock(mineralChestGold = MazeTowers.BlockGoldChest,
			"gold_chest");
		GameRegistry.registerBlock(mineralChestDiamond = MazeTowers.BlockDiamondChest,
			"diamond_chest");
		GameRegistry.registerBlock(hiddenButton = MazeTowers.BlockHiddenButton,
			"quartz_button");
		GameRegistry.registerBlock(resistantDoorPrismarine = MazeTowers.BlockPrismarineDoor, null,
			"prismarine_brick_door");
		GameRegistry.registerBlock(resistantDoorQuartz = MazeTowers.BlockQuartzDoor, null,
			"quartz_door");
		GameRegistry.registerBlock(resistantDoorEndStone = MazeTowers.BlockEndStoneDoor, null,
			"end_stone_door");
		GameRegistry.registerBlock(resistantDoorPurpur = MazeTowers.BlockPurpurDoor, null,
			"purpur_door");
		GameRegistry.registerBlock(resistantDoorObsidian = MazeTowers.BlockObsidianDoor, null,
			"obsidian_door");
		GameRegistry.registerBlock(
			resistantDoorBedrock = MazeTowers.BlockBedrockDoor, null, "bedrock_door");
		GameRegistry.registerBlock(lock = MazeTowers.BlockLock, ItemBlockLock.class, "lock");
		GameRegistry.registerBlock(redstone_clock = MazeTowers.BlockRedstoneClock,
			ItemBlockRedstoneClock.class, "redstone_clock");
		GameRegistry.registerBlock(redstone_clock_inverted = MazeTowers.BlockRedstoneClockInverted,
			ItemBlockRedstoneClock.class, "redstone_clock_inverted");
		GameRegistry.registerBlock(
			explosiveCreeperSkull = MazeTowers.BlockExplosiveCreeperSkull,
			"explosive_creeper_skull");
		GameRegistry.registerBlock(
			specialMobSpawner = MazeTowers.BlockSpecialMobSpawner,
			"special_mob_spawner");
		GameRegistry.registerBlock(
			vendorSpawner = MazeTowers.BlockVendorSpawner,
			"vendor_spawner");
		GameRegistry.registerBlock(
			chaoticSludge = MazeTowers.BlockChaoticSludge, null,
			"chaotic_sludge");
	}
}
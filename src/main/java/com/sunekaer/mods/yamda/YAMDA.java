package com.sunekaer.mods.yamda;

import com.sunekaer.mods.yamda.block.BlockNetherPortal;
import com.sunekaer.mods.yamda.block.BlockPortal;
import com.sunekaer.mods.yamda.config.YAMDAConfig;
import com.sunekaer.mods.yamda.dimension.YAMDABiomeProvider;
import com.sunekaer.mods.yamda.dimension.YAMDAChunkGenerator;
import com.sunekaer.mods.yamda.dimension.YAMDADimension;
import com.sunekaer.mods.yamda.netherdimension.YAMDANetherBiome;
import com.sunekaer.mods.yamda.netherdimension.YAMDANetherChunkGenerator;
import com.sunekaer.mods.yamda.netherdimension.YAMDANetherDimension;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.NetherBiome;
import net.minecraft.world.biome.provider.BiomeProviderType;
import net.minecraft.world.biome.provider.SingleBiomeProviderSettings;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.ChunkGeneratorType;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

import java.util.function.BiFunction;

@Mod(YAMDA.MODID)
public class YAMDA {

    public static final String MODID = "yamda";
    public static final ResourceLocation YAMDA_DIM = new ResourceLocation(MODID, "yamda_dim");
    public static final ResourceLocation YAMDA_NETHER_DIM = new ResourceLocation(MODID, "yamda_nether_dim");
    public static final ResourceLocation YAMDA_NETHER_BIOME = new ResourceLocation(MODID, "yamda_nether");

    public static ModDimension dimension = new ModDimension() {
        @Override
        public BiFunction<World, DimensionType, ? extends Dimension> getFactory() {
            return YAMDADimension::new;
        }
    }.setRegistryName(YAMDA_DIM);

    public static ModDimension netherDimension = new ModDimension() {
        @Override
        public BiFunction<World, DimensionType, ? extends Dimension> getFactory() {
            return YAMDANetherDimension::new;
        }
    }.setRegistryName(YAMDA_NETHER_DIM);

    public static Biome netherBiome = new YAMDANetherBiome()
            .setRegistryName(YAMDA_NETHER_BIOME);

    public static ChunkGeneratorType<GenerationSettings, YAMDAChunkGenerator> generatorType = new ChunkGeneratorType<>(YAMDAChunkGenerator::new, false, GenerationSettings::new);
    public static ChunkGeneratorType<GenerationSettings, YAMDANetherChunkGenerator> netherGeneratorType = new ChunkGeneratorType<>(YAMDANetherChunkGenerator::new, false, GenerationSettings::new);

    //public static BiomeProviderType<SingleBiomeProviderSettings, YAMDABiomeProvider> biomeProviderType = new BiomeProviderType<>(YAMDABiomeProvider::new, SingleBiomeProviderSettings::new);

    public static BlockPortal portal = new BlockPortal();

    public static final ItemGroup GROUP = new ItemGroup(MODID) {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(portal);
        }
    };

    public static BlockNetherPortal netherPortal = new BlockNetherPortal();

    public YAMDA() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, YAMDAConfig.configSpec);
    }
}

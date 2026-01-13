package net.boblercat.tutorialmod.datagen;

import net.boblercat.tutorialmod.block.ModBlocks;
import net.boblercat.tutorialmod.item.Moditems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.ZYNITE_BLOCK);
        addDrop(ModBlocks.RAW_ZYNITE_BLOCK);
        addDrop(ModBlocks.SOUNDBLOCK);

        addDrop(ModBlocks.ZYNITE_ORE,oreDropsWithBonus(ModBlocks.ZYNITE_ORE, Moditems.RAW_ZYNITE,1.0f,1.0f,Moditems.RANDOM_ORB,0.02f));
        addDrop(ModBlocks.DEEPSLATE_ZYNITE_ORE,oreDropsWithBonus(ModBlocks.DEEPSLATE_ZYNITE_ORE, Moditems.RAW_ZYNITE,1.0f,1.0f,Moditems.RANDOM_ORB,0.03f));
        addDrop(ModBlocks.NETHER_ZYNITE_ORE,oreDropsWithBonus(ModBlocks.NETHER_ZYNITE_ORE, Moditems.RAW_ZYNITE,1.0f,2.0f,Moditems.RANDOM_ORB,0.05f));
        addDrop(ModBlocks.END_STONE_ZYNITE_ORE,oreDropsWithBonus(ModBlocks.END_STONE_ZYNITE_ORE, Moditems.RAW_ZYNITE,2.0f,3.0f,Moditems.RANDOM_ORB,0.8f));

    }

    public LootTable.Builder advancedOreDrops(Block drop, Item item, float min, float max) {
        return dropsWithSilkTouch(
                drop,
                (LootPoolEntry.Builder<?>)this.applyExplosionDecay(
                        drop,
                        ItemEntry.builder(item)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(min, max)))
                                .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))
                )
        );
    }

    public LootTable.Builder oreDropsWithBonus(Block drop, Item item, float min, float max, Item bonus, float change){
        return advancedOreDrops(drop,item,min,max)
                .pool(LootPool.builder()
                .with(ItemEntry.builder(bonus))
                .conditionally(RandomChanceLootCondition.builder(change))
                .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))
                    );
    }
}

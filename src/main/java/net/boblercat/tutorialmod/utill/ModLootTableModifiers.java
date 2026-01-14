package net.boblercat.tutorialmod.utill;

import net.boblercat.tutorialmod.item.Moditems;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class ModLootTableModifiers {
    private static final Identifier ZOMBIE_ID =
            new Identifier("minecraft","entities/zombie");
    private static final Identifier WEAPONSMITH_ID =
            new Identifier("minecraft","chests/village/village_weaponsmith");
    private static final Identifier PYRAMID_ID =
            new Identifier("minecraft","chests/dessert_pyramid");
    public static void modifyLootTables(){
        LootTableEvents.MODIFY.register((resourceManager, lootManager, identifier, builder, lootTableSource) ->{
            if(ZOMBIE_ID.equals(identifier)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.05f))
                        .with(ItemEntry.builder(Moditems.METAL_DETECTOR))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)).build());

                builder.pool(poolBuilder.build());
            }
            if(WEAPONSMITH_ID.equals(identifier)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.5f))
                        .with(ItemEntry.builder(Moditems.WITHERING_SHANK))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,5.0f)).build());

                builder.pool(poolBuilder.build());
            }
            if(PYRAMID_ID.equals(identifier)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.5f))
                        .with(ItemEntry.builder(Moditems.WITHERING_SHANK))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,5.0f)).build());

                builder.pool(poolBuilder.build());
            }

            if(ZOMBIE_ID.equals(identifier)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.15f))
                        .with(ItemEntry.builder(Moditems.TOMATO_SEEDS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)).build());

                builder.pool(poolBuilder.build());
                }
        } );

    }

}

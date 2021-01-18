package mobiusstudios.recipeace.data;

import mobiusstudios.recipeace.Recipeace;
import mobiusstudios.recipeace.data.client.ModItemModelProvider;
import mobiusstudios.recipeace.data.loot.ModLootModifierProvider;
import mobiusstudios.recipeace.data.recipes.ModRecipeProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = Recipeace.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class DataGenerators {
    private DataGenerators() {
    }

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        generator.addProvider(new ModItemModelProvider(generator, existingFileHelper));
        generator.addProvider(new ModRecipeProvider(generator));
        generator.addProvider(new ModLootModifierProvider(generator));
    }
}

package mobiusstudios.recipeace.data.client;

import mobiusstudios.recipeace.Recipeace;
import mobiusstudios.recipeace.data.client.items.GoldRod;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, Recipeace.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        ModelFile itemGenerated = getExistingFile(new ResourceLocation("item/generated"));

        getBuilder(GoldRod.UNLOCALIZED_NAME)
                .parent(itemGenerated)
                .texture("layer0", GoldRod.TEXTURE_PATH_0);
    }
}

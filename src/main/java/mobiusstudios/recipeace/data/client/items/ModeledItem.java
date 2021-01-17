package mobiusstudios.recipeace.data.client.items;

public class ModeledItem extends UnmodeledItem {
    public final String MODEL_PATH;

    public ModeledItem(String unlocalizedName, String modelPath, String texturePath) {
        super(unlocalizedName, texturePath);
        this.MODEL_PATH = modelPath;
    }
}

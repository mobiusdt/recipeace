package mobiusstudios.recipeace.setup;

import mobiusstudios.recipeace.data.client.items.GoldRod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;

public class ModItems {
    public static final RegistryObject<Item> GOLD_ROD = Registration.ITEMS
            .register(GoldRod.UNLOCALIZED_NAME, () -> createItem(GoldRod.ITEM_GROUP));

    public static void register() {

    }

    private static Item createItem(ItemGroup itemGroup) {
        return new Item(new Item.Properties().group(itemGroup));
    }
}

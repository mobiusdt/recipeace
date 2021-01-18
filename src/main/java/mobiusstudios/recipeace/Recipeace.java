package mobiusstudios.recipeace;

import mobiusstudios.recipeace.setup.Registration;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Recipeace.MOD_ID)
public class Recipeace {
    public static final String MOD_ID = "recipeace";
    public static final String MOD_NAME = "Recipeace";
    public static final String MOD_PREFIX = MOD_ID + ":";

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public Recipeace() {
        LOGGER.info("Starting Recipeace");
        Registration.register();
    }

    public static final ItemGroup ITEM_GROUP = new ItemGroup(MOD_ID) {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(Items.CREEPER_HEAD);
        }
    };
}

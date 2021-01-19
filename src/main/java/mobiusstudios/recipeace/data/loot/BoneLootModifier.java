package mobiusstudios.recipeace.data.loot;

import com.google.gson.JsonObject;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;

import javax.annotation.Nonnull;
import java.util.List;

public class BoneLootModifier extends LootModifier {
    public BoneLootModifier(ILootCondition[] conditionsIn) {
        super(conditionsIn);
    }
    @Nonnull
    @Override
    protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
        return generatedLoot;
    }

    public static class Serializer extends GlobalLootModifierSerializer<BoneLootModifier> {

        @Override
        public BoneLootModifier read(ResourceLocation location, JsonObject object, ILootCondition[] ailootcondition) {
            return new BoneLootModifier(ailootcondition);
        }

        @Override
        public JsonObject write(BoneLootModifier instance) {
            return makeConditions(instance.conditions);
        }
    }
}

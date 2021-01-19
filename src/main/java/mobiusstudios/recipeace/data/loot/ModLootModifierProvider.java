package mobiusstudios.recipeace.data.loot;

import mobiusstudios.recipeace.Recipeace;
import net.minecraft.data.DataGenerator;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModLootModifierProvider extends GlobalLootModifierProvider {
    public ModLootModifierProvider(DataGenerator gen) {
        super(gen, Recipeace.MOD_ID);
    }

    private static final DeferredRegister<GlobalLootModifierSerializer<?>> GLM = DeferredRegister.create(ForgeRegistries.LOOT_MODIFIER_SERIALIZERS, Recipeace.MOD_ID);
    private static final RegistryObject<BoneLootModifier.Serializer> BONE_LOOTS = GLM.register("bone_loot", BoneLootModifier.Serializer::new);

    @Override
    protected void start() {
        add("BoneLootModifier", BONE_LOOTS.get(), new BoneLootModifier(
                new ILootCondition[]{

                }
        ));
    }

    @Override
    public <T extends IGlobalLootModifier> void add(String modifier, GlobalLootModifierSerializer<T> serializer, T instance) {
        super.add(modifier, serializer, instance);
    }

    @Override
    public String getName() {
        return Recipeace.MOD_NAME + " - Loot Modifier";
    }
}

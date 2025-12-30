package kkkonsss.act.item;

import kkkonsss.act.ACT;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ACT.MODID);

    public static final Supplier<CreativeModeTab> ACT_TAB = CREATIVE_TABS.register(
            "act",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.act"))  // Название вкладки
                    .icon(() -> new ItemStack(ModItems.RUBIKS_CUBE.get()))  // Иконка
                    .displayItems((params, output) -> {
                        // Добавляем предметы в эту вкладку
                        output.accept(ModItems.RUBIKS_CUBE.get());
                        // Здесь можно добавлять другие предметы/блоки
                    })
                    .build()
    );

    public static void register(IEventBus eventBus) {
        CREATIVE_TABS.register(eventBus);
    }
}
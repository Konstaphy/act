package kkkonsss.act.item;

import kkkonsss.act.ACT;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    // Создаем регистратор для предметов
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(ACT.MODID);

    // Регистрируем наш кастомный предмет
    public static final DeferredItem<Item> RUBIKS_CUBE = ITEMS.register(
            "rubik",  // ID предмета (будет rubikmod:rubiks_cube)
            () -> new Rubiks(
                    new Item.Properties()
                            .stacksTo(1)           // Не стакается
                            .fireResistant()       // Не горит в огне/лаве
                            .rarity(net.minecraft.world.item.Rarity.RARE)  // Редкий предмет (фиолетовый текст)
            )
    );

    // Метод для регистрации в главном классе
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
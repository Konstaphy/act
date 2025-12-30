package kkkonsss.act;

import kkkonsss.act.item.ModCreativeTabs;
import kkkonsss.act.item.ModItems;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@Mod(ACT.MODID)
public class ACT {
    public static final String MODID = "act";

    public ACT(IEventBus modEventBus) {
        ModItems.ITEMS.register(modEventBus);
        ModCreativeTabs.register(modEventBus);

        modEventBus.addListener(this::onClientSetup);
    }

    private void onClientSetup(FMLClientSetupEvent event) {
        // Клиент-сайд инициализация
        event.enqueueWork(() -> {
            // Здесь можно регистрировать что-то только для клиента
        });
    }
}
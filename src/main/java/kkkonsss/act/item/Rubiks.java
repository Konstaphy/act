package kkkonsss.act.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class Rubiks extends Item {
    // Конструктор с настройками предмета
    public Rubiks(Properties properties) {
        super(properties
                .stacksTo(1)          // Максимум 1 в стаке
                .durability(100)      // Прочность (если нужно)
        );
    }

    // Право-клик по предмету в руке
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);

        if (!level.isClientSide()) {
            // Сервер-сайд логика
            player.sendSystemMessage(
                    Component.literal("Вы покрутили кубик Рубика!")
                            .withStyle(ChatFormatting.GOLD)
            );
        }

        return InteractionResultHolder.sidedSuccess(itemStack, level.isClientSide());
    }
}

package com.miningmark48.prefixmod.event;

import com.miningmark48.mininglib.utility.ModLogger;
import com.miningmark48.prefixmod.reference.EnumPrefixTypes;
import com.miningmark48.prefixmod.init.prefixes.ToolPrefixesHandler;
import com.miningmark48.prefixmod.init.prefixes.WeaponPrefixesHandler;
import com.miningmark48.prefixmod.utility.HandlePrefix;
import net.minecraft.item.*;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

import java.util.ConcurrentModificationException;

public class EventOnCraft {

    @SubscribeEvent
    public void onCraft(PlayerEvent.ItemCraftedEvent event) {
        if (!event.player.getEntityWorld().isRemote) {
            ItemStack stack = event.crafting;
            Item item = stack.getItem();

            try {
                if (item instanceof ItemSword) {
                    HandlePrefix.addPrefix(stack, EnumPrefixTypes.WEAPON, WeaponPrefixesHandler.prefixNameMap, WeaponPrefixesHandler.modifierMap, WeaponPrefixesHandler.modifierNameMap);
                } else if (item instanceof ItemPickaxe || item instanceof ItemSpade || item instanceof ItemAxe || item instanceof ItemHoe || item instanceof ItemShears) {
                    HandlePrefix.addPrefix(stack, EnumPrefixTypes.TOOL, ToolPrefixesHandler.prefixNameMap, ToolPrefixesHandler.modifierMap, ToolPrefixesHandler.modifierNameMap);
                }
            } catch (NullPointerException | ConcurrentModificationException e) {
                ModLogger.fatal("Error occurred while adding prefix to item, please report to mod author.");
                e.printStackTrace();
            }

        }
    }

}

package com.samdevbr.proarchitect.registry;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import com.samdevbr.proarchitect.ProArchitect;
import com.samdevbr.proarchitect.item.BlueprintPaper;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;

public class ItemRegistry {
    public static final BlueprintPaper BLUEPRINT_PAPER_PAPER;

    private static <T extends Item> T register(String id, T item) {
        return Registry.register(Registry.ITEM, new Identifier(ProArchitect.ID, id), item);
    }

    public static void boot() {}

    static {
        BLUEPRINT_PAPER_PAPER = register("blueprint_paper", new BlueprintPaper(
                new FabricItemSettings().group(ItemGroup.MISC)
        ));
    }
}

package com.samdevbr.proarchitect.item;

import net.minecraft.item.Item;
import net.minecraft.util.ActionResult;
import net.minecraft.item.ItemUsageContext;
import com.samdevbr.proarchitect.event.Event;
import net.minecraft.server.world.ServerWorld;
import com.samdevbr.proarchitect.graphics.Size;
import com.samdevbr.proarchitect.networking.packet.SpawnGridPacket;

public class BlueprintPaper extends Item {
    public BlueprintPaper(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if (context.getWorld().isClient()) return super.useOnBlock(context);
        if (context.getPlayer() == null) return super.useOnBlock(context);

        var world = (ServerWorld) context.getWorld();

        Event.dispatch(SpawnGridPacket.build(
                world,
                new Size(3,3,3),
                context.getBlockPos()
        ));

        return ActionResult.SUCCESS;
    }
}

package net.flugi.perpetuality.bulshittt;

import net.fabricmc.fabric.api.attachment.v1.AttachmentRegistry;
import net.fabricmc.fabric.api.attachment.v1.AttachmentSyncPredicate;
import net.fabricmc.fabric.api.attachment.v1.AttachmentType;
import net.flugi.perpetuality.Perpetuality;
import net.minecraft.util.Identifier;
import net.minecraft.util.Unit;

public class ModEntities {


    public static final AttachmentType<Unit> CONTRADICTORY = AttachmentRegistry.create(Perpetuality.id("contradictory"),
            builder -> builder.syncWith(Unit.PACKET_CODEC , AttachmentSyncPredicate.targetOnly())
            );


}

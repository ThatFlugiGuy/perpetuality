package net.flugi.perpetuality.entity;

import net.fabricmc.fabric.api.attachment.v1.AttachmentRegistry;
import net.fabricmc.fabric.api.attachment.v1.AttachmentSyncPredicate;
import net.fabricmc.fabric.api.attachment.v1.AttachmentType;
import net.flugi.perpetuality.Perpetuality;
import net.minecraft.util.Unit;
import net.minecraft.util.math.Vec3d;

public class ModEntities {

    public static final AttachmentType<Unit> INSIGHT = AttachmentRegistry.create(Perpetuality.id("insight"),
        builder -> builder.syncWith(Unit.PACKET_CODEC, AttachmentSyncPredicate.targetOnly())
    );

}

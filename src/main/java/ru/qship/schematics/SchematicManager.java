package ru.qship.schematics;

import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.WorldEditException;
import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.command.ClipboardCommands;
import com.sk89q.worldedit.extent.clipboard.Clipboard;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormat;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormats;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardReader;
import com.sk89q.worldedit.function.operation.Operation;
import com.sk89q.worldedit.function.operation.Operations;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldedit.math.transform.AffineTransform;
import com.sk89q.worldedit.session.ClipboardHolder;

import org.bukkit.World;
import org.bukkit.generator.structure.Structure;
import org.checkerframework.checker.units.qual.A;
import org.checkerframework.checker.units.qual.C;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class SchematicManager {

    public static void paste(double x, double y, double z, Clipboard clipboard, World world, int zRotate) throws WorldEditException {
        ClipboardHolder holder = new ClipboardHolder(clipboard);
        holder.setTransform(new AffineTransform().rotateY(zRotate));
        try (EditSession editSession = WorldEdit.getInstance().newEditSessionBuilder().world(BukkitAdapter.adapt(world)).build()) {
            Operation operation = holder
                    .createPaste(editSession)
                    .to(BlockVector3.at(x, y, z))
                    .ignoreAirBlocks(false)
                    .build();
            Operations.complete(operation);
        }
    }
    public static Clipboard schematic(File file){
        ClipboardFormat format = ClipboardFormats.findByFile(file);
        Clipboard clipboard;
        try (ClipboardReader reader = format.getReader(new FileInputStream(file))) {
            clipboard = reader.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return clipboard;
    }




}

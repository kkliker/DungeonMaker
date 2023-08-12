package ru.qship.room.rooms.actions_rooms;

import com.sk89q.worldedit.extent.clipboard.Clipboard;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import ru.qship.DungeonMaster;
import ru.qship.room.Facing;
import ru.qship.room.Room;
import ru.qship.room.RoomExit;
import ru.qship.schematics.SchematicManager;

import java.io.File;
import java.util.List;

public class Tunnel_Puzzle_Room extends Room {
    public Tunnel_Puzzle_Room(Facing roomFacing, int centerX, int centerY, int centerZ, Room nextRoom) {
        super(
                List.of(new RoomExit(0,0,-10,
                        roomFacing,Facing.NORTH)),
                roomFacing,
                centerX, centerY, centerZ,
                SchematicManager.schematic(new File("./schematics/tunnel_puzzle.schem")),
                nextRoom);
    }

    /*

mobs 2 -  x 0 z -10
tunnel_boss  - x 0 z - 10
tunnel_puzzle x 0 z -10
tunnel1_mobs x 0 z -12

     */


    @Override
    public void run() {

    }
    @Override
    public void end(){

    }
}

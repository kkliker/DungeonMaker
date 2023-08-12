package ru.qship.room.rooms;

import ru.qship.room.Facing;
import ru.qship.room.Room;
import ru.qship.room.RoomExit;
import ru.qship.schematics.SchematicManager;

import java.io.File;
import java.util.List;

public class StartRoom {

    public static Room room(int startx, int starty, int startz, Facing facing){
        return new Room(
                List.of(
                        new RoomExit(0,0,0, Facing.NORTH,facing)),
                facing,
                startx,starty,startz,
                SchematicManager.schematic(new File("./schematics/tunnel_start.schem")),
                null
        );
    }
}

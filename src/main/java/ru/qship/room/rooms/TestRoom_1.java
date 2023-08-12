package ru.qship.room.rooms;

import ru.qship.room.Facing;
import ru.qship.room.Room;
import ru.qship.room.RoomExit;
import ru.qship.schematics.SchematicManager;

import java.io.File;
import java.util.List;

public class TestRoom_1 {


    // x 0 z -8 | x 4 z -4

    public static Room room(int startx,int starty,int startz,Facing facing){
        return new Room(
                List.of(
                        new RoomExit(0,0,-8, Facing.NORTH,facing),
                        new RoomExit(-4,0,-4, Facing.WEST,facing)),
                facing,
                startx,starty,startz,
                SchematicManager.schematic(new File("./schematics/room_1.schem")),
                null
        );
    }

}

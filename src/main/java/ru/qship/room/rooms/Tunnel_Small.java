package ru.qship.room.rooms;

import ru.qship.room.Facing;
import ru.qship.room.Room;
import ru.qship.room.RoomExit;
import ru.qship.schematics.SchematicManager;

import java.io.File;
import java.util.List;
import java.util.Random;

public class Tunnel_Small {

    private static Random rnd = new Random();



    public static Room room(int startx, int starty, int startz, Facing facing){
        return new Room(
                List.of(
                        new RoomExit(0,0,-7, Facing.NORTH,facing)),
                facing,
                startx,starty,startz,
                SchematicManager.schematic(new File("./schematics/tunnel1_small.schem")),
                null
        );
    }


    public static Room room2(int startx, int starty, int startz, Facing facing){
        return new Room(
                List.of(
                        new RoomExit(0,0,-10, Facing.NORTH,facing)),
                facing,
                startx,starty,startz,
                SchematicManager.schematic(new File("./schematics/tunnel2_small.schem")),
                null
        );
    }

    public static Room room3(int startx, int starty, int startz, Facing facing){
        return new Room(
                List.of(
                        new RoomExit(-7,0,-7, Facing.WEST,facing)),
                facing,
                startx,starty,startz,
                SchematicManager.schematic(new File("./schematics/turn1_1.schem")),
                null
        );
    }


    // x -7 z -7 | x 7 z -7 || x -7 z -7 | x 7 z -7 | x 0 z -14
    public static Room room4(int startx, int starty, int startz, Facing facing){
        return new Room(
                List.of(
                        new RoomExit(-7,0,-7, Facing.WEST,facing),
                        new RoomExit(7,0,-7, Facing.EAST,facing)),
                facing,
                startx,starty,startz,
                SchematicManager.schematic(new File("./schematics/turn2_2.schem")),
                null
        );
    }

    public static Room room5(int startx, int starty, int startz, Facing facing){
        return new Room(
                        List.of(
                        new RoomExit(-7,0,-7, Facing.WEST,facing),
                        new RoomExit(7,0,-7, Facing.EAST,facing),
                        new RoomExit(0,0,-14, Facing.NORTH,facing)
                        ),
                        facing,
                        startx,starty,startz,
                        SchematicManager.schematic(new File("./schematics/turn3_3.schem")),
                null
                );
    }
    public static Room[] variations(int startx, int starty, int startz, Facing facing){
        return new Room[]{
                room(startx, starty, startz, facing),
                room2(startx, starty, startz, facing),
                room3(startx, starty, startz, facing),
                room4(startx, starty, startz, facing),
                room5(startx, starty, startz, facing)};
    }

    public static Room getRandomVariation(int startx, int starty, int startz, Facing facing){

        Room[] vars = variations(startx, starty, startz, facing);
        return vars[rnd.nextInt(vars.length)];

    }

}

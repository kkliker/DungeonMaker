package ru.qship.room.rooms;

import org.bukkit.Location;
import ru.qship.room.Facing;
import ru.qship.room.Room;
import ru.qship.room.RoomExit;
import ru.qship.room.rooms.actions_rooms.*;
import ru.qship.schematics.SchematicManager;

import java.io.File;
import java.util.List;
import java.util.Random;

public class Tunnel_Action_Rooms {

    static Random rnd = new Random();

    public static Room boss_room(int startx, int starty, int startz, Facing facing){
        Room tunnelBoss = new Tunnel_Boss_Room(facing, startx,starty,startz,null);
        Location endLoc = tunnelBoss.exits.get(0).getExitAbsoluteLocation(startx,starty,startz);
        System.out.println("ENDLOC " + endLoc);
        tunnelBoss.nextRoom = new Tunnel_End_Room(facing,(int) endLoc.getX(), (int) endLoc.getY(), (int) endLoc.getZ(),null);

        return tunnelBoss;
    }


    public static Room puzzle_room(int startx, int starty, int startz, Facing facing){
        return new Tunnel_Puzzle_Room(
                facing,
                startx,starty,startz,
                null
        );
    }

    public static Room mob_1_room(int startx, int starty, int startz, Facing facing){
        return new Tunnel_Mobs_1_Room(
                facing,
                startx,starty,startz,
                null
        );
    }


    // x -7 z -7 | x 7 z -7 || x -7 z -7 | x 7 z -7 | x 0 z -14
    public static Room mob_2_room(int startx, int starty, int startz, Facing facing){
        return new Tunnel_Mobs_2_Room(
                facing,
                startx,starty,startz,
                null
        );
    }


    public static Room[] variations(int startx, int starty, int startz, Facing facing){
        return new Room[]{
                boss_room(startx, starty, startz, facing),
                puzzle_room(startx, starty, startz, facing),
                mob_1_room(startx, starty, startz, facing),
                mob_2_room( startx, starty, startz, facing),};
    }

    public static Room getRandomVariation(int startx, int starty, int startz, Facing facing){

        Room[] vars = variations(startx, starty, startz, facing);
        return vars[rnd.nextInt(vars.length)];

    }
}

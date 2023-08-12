package ru.qship.room;

import com.sk89q.worldedit.WorldEditException;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import ru.qship.DungeonMaster;
import ru.qship.room.rooms.Tunnel_Action_Rooms;
import ru.qship.room.rooms.Tunnel_Small;
import ru.qship.schematics.SchematicManager;

import java.util.Random;

public class RoomGenerator {


    // North -> West
    static Random rnd = new Random();
    public static void next(Room currentRoom, Player p) throws WorldEditException {

        if(currentRoom.exits.size() == 0){
            return;
        }

        RoomExit rndExit = currentRoom.exits.get(rnd.nextInt(currentRoom.exits.size()));
        Location absoluteExitLocaation  = rndExit.getExitAbsoluteLocation(currentRoom.centerX, currentRoom.centerY, currentRoom.centerZ);

        Room room = Tunnel_Small.getRandomVariation(
                (int) absoluteExitLocaation.getX(),
                (int) absoluteExitLocaation.getY(),
                (int) absoluteExitLocaation.getZ(),rndExit.facing());

        room.run();

        if (currentRoom.nextRoom != null){

            Room newRoom = currentRoom.nextRoom;
            newRoom.facing(rndExit.facing()) ;

            SchematicManager.paste(
                    (int) absoluteExitLocaation.getX() - 0.5,(int) absoluteExitLocaation.getY(), (int) absoluteExitLocaation.getZ() - 0.5,
                    newRoom.schematic,  Bukkit.getWorld("world"), newRoom.facing.label);
            DungeonMaster.currentRoom.put(p.getUniqueId(),newRoom);

            return;
        }

        int[] rndMass = new int[]{0,1,2,3,4,5,6,7,9};
        if (rndMass[rnd.nextInt(rndMass.length)] <= 1){

            room = Tunnel_Action_Rooms.getRandomVariation(
                    (int) absoluteExitLocaation.getX(),
                    (int) absoluteExitLocaation.getY(),
                    (int) absoluteExitLocaation.getZ(),rndExit.facing());
        }

        DungeonMaster.currentRoom.put(p.getUniqueId(),room);
        SchematicManager.paste(
                (int) absoluteExitLocaation.getX() - 0.5,(int) absoluteExitLocaation.getY(), (int) absoluteExitLocaation.getZ() - 0.5,
                room.schematic,  Bukkit.getWorld("world"), room.facing.label);

    }
}

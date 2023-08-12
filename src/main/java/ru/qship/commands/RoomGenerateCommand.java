package ru.qship.commands;

import com.sk89q.worldedit.WorldEditException;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.qship.DungeonMaster;
import ru.qship.room.Facing;
import ru.qship.room.Room;
import ru.qship.room.rooms.StartRoom;
import ru.qship.room.rooms.Tunnel_Small;
import ru.qship.schematics.SchematicManager;

public class RoomGenerateCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        int xRotate =  Integer.parseInt(args[0]);

        Player player = (Player) sender;
        Location playerLocation = player.getLocation();

        Facing facing = Facing.from(xRotate);

        Room room = StartRoom.room((int) playerLocation.getX(), (int) playerLocation.getY(), (int) playerLocation.getZ(),facing);

        System.out.println("[FIRST EXIT LOC] " + room.exits.get(0).getExitAbsoluteLocation((int) playerLocation.getX(), (int) playerLocation.getY(), (int) playerLocation.getZ()));

        // DungeonSession dungeonSession = DungeonMaster.dungeonSessionHashMap.get(player.getUniqueId());


        try {
            SchematicManager.paste(playerLocation.getX(),playerLocation.getY(),playerLocation.getZ(),room.schematic,player.getWorld(),xRotate);
        } catch (WorldEditException e) {
            throw new RuntimeException(e);
        }

        DungeonMaster.currentRoom.put(player.getUniqueId(),room);

        return true;
    }






}

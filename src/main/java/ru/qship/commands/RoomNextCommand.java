package ru.qship.commands;

import com.sk89q.worldedit.WorldEditException;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.qship.DungeonMaster;
import ru.qship.room.Room;
import ru.qship.room.RoomGenerator;

public class RoomNextCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;
        Room currentRoom = DungeonMaster.currentRoom.get(player.getUniqueId());

        try {
            RoomGenerator.next(currentRoom,player);
        } catch (WorldEditException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}

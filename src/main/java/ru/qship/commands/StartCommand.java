package ru.qship.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.qship.DungeonMaster;
import ru.qship.room.RoomGenerator;

public class StartCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;

        Location location = new Location(DungeonMaster.getDungeonWorld(),0,100,0);


        return true;
    }


}

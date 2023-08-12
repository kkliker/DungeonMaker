package ru.qship;

import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.plugin.java.JavaPlugin;
import ru.qship.commands.RoomGenerateCommand;
import ru.qship.commands.RoomNextCommand;
import ru.qship.commands.StartCommand;
import ru.qship.room.Room;
import ru.qship.sessions.DungeonSession;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class DungeonMaster extends JavaPlugin {

    private static World dungeonWorld;
    public static Set<Integer> zDungeonSet = new HashSet<>();
    public static HashMap<UUID, DungeonSession> dungeonSessionHashMap = new HashMap<>();
    public static HashMap<UUID, Room> currentRoom = new HashMap<>();

    public static DungeonMaster instance;
    public DungeonMaster(){
        instance = this;
    }

    @Override
    public void onEnable() {

        dungeonWorld = this.getServer().createWorld(new WorldCreator("dungeon"));
        dungeonWorld.setAutoSave(false);

        this.getCommand("room").setExecutor(new RoomGenerateCommand());
        this.getCommand("dungeon").setExecutor(new StartCommand());
        this.getCommand("next").setExecutor(new RoomNextCommand());

    }
    @Override
    public void onDisable() {
        super.onDisable();
    }

    public static DungeonMaster getInstance(){
        return instance;
    }
    public static World getDungeonWorld(){
        return dungeonWorld;
    }

}

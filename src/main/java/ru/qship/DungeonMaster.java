package ru.qship;

import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.plugin.java.JavaPlugin;

public class DungeonMaster extends JavaPlugin {

    public static World dungeonWorld;
    @Override
    public void onEnable() {

        dungeonWorld = this.getServer().createWorld(new WorldCreator("dungeon"));
        dungeonWorld.setAutoSave(false);

    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
}

package ru.qship.sessions;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import ru.qship.room.Room;

import java.util.List;
import java.util.UUID;

public class DungeonSession {

    // разница z - 2000

    private World bukkitWorld;
    private List<UUID> currentPlayers;
    private Room currentRoom;
    private int zCoord;


    public DungeonSession(World world,List<UUID> players,Room startRoom, int zCoord){
        this.bukkitWorld = world;
        this.currentPlayers.addAll(players);
        this.currentRoom = startRoom;
    }

    public void delete(){

        currentPlayers.forEach(uuid -> {

          Player player = Bukkit.getPlayer(uuid);
          if(player == null){
              return;
          }
          //player.teleport()

        });
    }

    public Room currentRoom(){
        return this.currentRoom;
    }
    public int zCoord(){
        return this.zCoord;
    }
    public World world(){
        return this.bukkitWorld;
    }
    public List<UUID> players() {
        return this.currentPlayers;
    }



}

package ru.qship.room;

import com.sk89q.worldedit.extent.clipboard.Clipboard;

import javax.annotation.Nullable;
import java.util.List;

public class Room {


    public List<RoomExit> exits;
    public Facing facing;
    public int length;
    public int centerX;
    public int centerY;
    public int centerZ;
    public @Nullable Room nextRoom;

    public Clipboard schematic;

    public Room(List<RoomExit> roomExits,Facing roomFacing,int centerX,int centerY,int centerZ,Clipboard schematic,Room nextRoom){
        this.facing = roomFacing;

        this.centerX = centerX;
        this.centerY = centerY;
        this.centerZ = centerZ;
        this.schematic = schematic;

        this.length = schematic.getRegion().getLength();
        this.exits = roomExits;
        roomExits.forEach(roomExit -> {
            Facing toSet = roomExit.facing();
            if(facing == Facing.NORTH){
                return;
            }

            int ord = (toSet.label + facing.label) % 360;
            roomExit.facing(Facing.from(ord));
        });

        roomExits.forEach(roomExit -> {
            System.out.println("[EXIT COORDS] " +  roomExit.facing() + " " + roomExit.getExitAbsoluteLocation(centerX,centerY,centerZ));
        });

    }

    public void run(){

    }

    public void end(){

    }

    public void facing(Facing facing){
        this.facing = facing;
    }



}

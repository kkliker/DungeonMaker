package ru.qship.room;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class RoomExit {


    // смещение относительно NORTH

    private double offsetX;
    private double offsetY;
    private double offsetZ;
    private Facing facing;
    private Facing roomFacing;

    public RoomExit(double offsetX, double offsetY,double offsetZ,Facing facing,Facing roomFacing){
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.offsetZ = offsetZ;
        this.facing = facing;
        this.roomFacing = roomFacing;
    };

    public double offsetX(){
        return this.offsetX;
    }
    public double offsetY(){
        return this.offsetY;
    }
    public double offsetZ(){
        return this.offsetZ;
    }
    public Facing facing(){
        return this.facing;
    }
    public void facing(Facing facing){
        this.facing = facing;
    }




    // NORTH x +2; z -4
    // SOUTH x -2 | z +4
    // EAST z +2 | x +4
    // WEST z -2 | x -4
    public Location getExitAbsoluteLocation(int xCenter,int yCenter,int zCenter){

        double xExitOffset = offsetX;
        double yExit = offsetY;
        double zExitOffset = offsetZ;


        switch (roomFacing){
            case SOUTH -> {
                xExitOffset = -xExitOffset;
                zExitOffset = -zExitOffset;
            }
            case WEST -> {
                double temp = -xExitOffset;
                xExitOffset = zExitOffset;
                zExitOffset = temp;
            }
            case EAST -> {
                double temp = xExitOffset;
                xExitOffset = -zExitOffset;
                zExitOffset = temp;

            }
        }

        System.out.println("offsetX " + xExitOffset + "offsetY" + yExit + "offsetZ" + zExitOffset );

        return new Location(Bukkit.getWorld("world"),xExitOffset + xCenter,yExit + yCenter, zExitOffset + zCenter);
    }

    public Location getExitAbsoluteLocationWithOffset(int xCenter,int yCenter,int zCenter, int roomLength){

        double xExitOffset = offsetX;
        double yExit = offsetY;
        double zExitOffset = offsetZ;


        switch (roomFacing){
            case SOUTH -> {
                xExitOffset = -xExitOffset;
                zExitOffset = -zExitOffset;
            }
            case WEST -> {
                double temp = -xExitOffset;
                xExitOffset = zExitOffset;
                zExitOffset = temp;
            }
            case EAST -> {
                double temp = xExitOffset;
                xExitOffset = -zExitOffset;
                zExitOffset = temp;

            }
        }

        switch (facing){
            case SOUTH -> {
                zExitOffset += roomLength;
            }
            case WEST -> {
                xExitOffset -= roomLength;
            }
            case EAST -> {
                xExitOffset += roomLength;
            }
            case NORTH -> {
                zExitOffset -= roomLength;
            }
        }

        System.out.println("offsetX " + xExitOffset + "offsetY" + yExit + "offsetZ" + zExitOffset );

        return new Location(Bukkit.getWorld("world"),xExitOffset + xCenter,yExit + yCenter, zExitOffset + zCenter);
    }

}

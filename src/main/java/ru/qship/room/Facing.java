package ru.qship.room;

import java.util.Arrays;

public enum Facing {

    NORTH(0),
    SOUTH(180),
    WEST(90),
    EAST(270);

    // 0 - north | 90 - west | 180 - south | 270 - east

    int label;
    Facing(int i) {
        this.label = i;
    }

    public static Facing from(int value){
        Facing fcg = null;
        for(Facing facing : Facing.values()){

            if(facing.label == value){
                fcg = facing;
                break;
            }
        }
        return fcg;
    }

    public static Facing inverse(Facing facing){
        switch (facing){
            case NORTH -> {
                return Facing.SOUTH;
            }
            case SOUTH -> {
                return Facing.NORTH;
            }
            case WEST -> {
                return Facing.EAST;
            }
            case EAST -> {
                return Facing.WEST;
            }
        }
        return null;
    }

}

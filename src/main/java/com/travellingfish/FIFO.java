package com.travellingfish;

import java.util.LinkedList;

public class FIFO {

    private LinkedList<Fish> fishList = new LinkedList<>();

    public void add(Fish fish) {
        fishList.addLast(fish);
    }

    public Fish get() {
        Fish fish = fishList.getFirst();
        fishList.removeFirst();
        return fish;
    }

    public boolean isAny() {
        if(fishList.isEmpty()) return false;
        return true;
    }

    @Override
    public String toString() {
        String result = "";
        for(Fish fish : fishList) {
            result += fish.toString() + "\n";
        }
        return result;
    }
}

package com.travellingfish;

import java.util.LinkedList;

public class FILO {

    private LinkedList<Fish> fishList = new LinkedList<>();

    public void add(Fish fish) {
        fishList.addFirst(fish);
    }

    public Fish get() {
        // UWAGA!!! Ostatnio wkladany element jest na początku listy, nie na końcu!
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

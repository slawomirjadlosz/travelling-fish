package com.travellingfish;

import java.util.LinkedList;

public class River {

    private FIFO fishesSwimmingToSource = new FIFO();
    private FILO fishesSwimmingToMouth = new FILO();
    private LinkedList<Fish> fishList = new LinkedList<>();
    public static final int NO_OF_FISH = 20;

    public River() {}

    public void addAtSource(Fish fish) {
        fishList.add(0, fish);
    }

    public void riverSimulation() {

        if(fishList.isEmpty()) {
            System.out.println("There is no fish in the river!");
        } else {
            for(int i=0; i<NO_OF_FISH; i++) {
                Fish fishFromRiver = fishList.get(i);

                if(fishFromRiver.getStream() == FishFactory.UP_STREAM) {
                    boolean isEaten = false;
                    while(fishesSwimmingToMouth.isAny()) {
                        Fish fishSwimmingToMouth = fishesSwimmingToMouth.get();
                        if(fishFromRiver.getSize() <= fishSwimmingToMouth.getSize()) {
                            fishesSwimmingToMouth.add(fishSwimmingToMouth);
                            isEaten = true;
                            break;
                        }
                    }
                    if(!isEaten) {
                        fishesSwimmingToSource.add(fishFromRiver);
                    }
                } else {
                    // Fish is moving towards mouth of the river
                    fishesSwimmingToMouth.add(fishFromRiver);
                }
            }
        }

    }

    private void riverUpdate(FIFO fishesSwimmingToSource, FILO fishesSwimmingToMouth) {
        fishList.clear();
        while(fishesSwimmingToSource.isAny()) {
            fishList.add(fishesSwimmingToSource.get());
        }
        while(fishesSwimmingToMouth.isAny()) {
            fishList.add(fishesSwimmingToMouth.get());
        }
    }

    private void fishesSwimmingToMouthFiloReload() {
        FILO filoFishesSwimmingToMouth = new FILO();
        while(fishesSwimmingToMouth.isAny()) {
            filoFishesSwimmingToMouth.add(fishesSwimmingToMouth.get());
        }
        fishesSwimmingToMouth = filoFishesSwimmingToMouth;
    }

    private void displayFishesSwimmingToSource() {
        System.out.println("------   Fishes swimming to Source   ------");
        System.out.println("<<<<<<<<<<<<<<   river flow   <<<<<<<<<<<<<");
        System.out.println(fishesSwimmingToSource.toString());
    }

    private void displayFishesSwimmingToMouth() {
        System.out.println("------   Fishes swimming to Mouth   ------");
        System.out.println("<<<<<<<<<<<<<<   river flow   <<<<<<<<<<<<<");
        System.out.println(fishesSwimmingToMouth.toString());
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

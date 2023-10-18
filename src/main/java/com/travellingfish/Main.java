package com.travellingfish;

public class Main {
    public static void main(String[] args) {

        River river = new River();
        for(int i = 0; i< River.NO_OF_FISH; i++) {
            river.addAtSource(FishFactory.createFish());
        }

        System.out.println("----------   BEFORE SIMULATION   ----------");
        System.out.println("<<<<<<<<<<<<<<   river flow   <<<<<<<<<<<<<");
        System.out.println(river.toString());

        river.riverSimulation();

        System.out.println("-----------   AFTER SIMULATION   ----------");
        System.out.println("<<<<<<<<<<<<<<   river flow   <<<<<<<<<<<<<");
        System.out.println(river.toString());

    }
}
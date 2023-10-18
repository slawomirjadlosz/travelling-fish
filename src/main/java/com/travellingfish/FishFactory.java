package com.travellingfish;

import java.util.Random;

public class FishFactory {

    public static final boolean UP_STREAM = false;

    private static class Carp implements Fish {

        private final int size;
        private final boolean stream;

        public Carp(int size, boolean stream) {
            this.size = size;
            this.stream = stream;
        }

        @Override
        public int getSize() {
            return size;
        }

        @Override
        public boolean getStream() {
            return stream;
        }

        @Override
        public String toString() {
            if(stream) {
                return "<'" + size + "><|";
            }
            return "|><" + size + "'>";
        }
    }

    public static Fish createFish() {
        return new Carp(randomSize(), randomStream());
    }

    private static int randomSize() {
        final int FIXED_SIZE = 86;
        Random random = new Random();
        int randomNumber = random.nextInt(1000);
        if(randomNumber < 0) {
            randomNumber = randomNumber*(-1);
        } else if (randomNumber == 0) {
            randomNumber = FIXED_SIZE;
        }
        return randomNumber;
    }

    private static boolean randomStream() {
        Random random = new Random();
        return random.nextBoolean();
    }

}

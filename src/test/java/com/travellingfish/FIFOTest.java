package com.travellingfish;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FIFOTest {

    @Test
    void testFIFO() {
        FIFO fifo = new FIFO();
        Fish fish1 = FishFactory.createFish();
        Fish fish2 = FishFactory.createFish();
        Fish fish3 = FishFactory.createFish();

        fifo.add(fish1);
        fifo.add(fish2);
        fifo.add(fish3);

        Fish retreivedFish = fifo.get();
        assertSame(retreivedFish, fish1);

        retreivedFish = fifo.get();
        assertSame(retreivedFish, fish2);

        retreivedFish = fifo.get();
        assertSame(retreivedFish, fish3);
    }
}
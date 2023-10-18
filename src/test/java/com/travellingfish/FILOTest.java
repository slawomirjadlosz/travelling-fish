package com.travellingfish;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FILOTest {

    @Test
    void testFILO() {
        FILO filo = new FILO();
        Fish fish1 = FishFactory.createFish();
        Fish fish2 = FishFactory.createFish();
        Fish fish3 = FishFactory.createFish();

        filo.add(fish1);
        filo.add(fish2);
        filo.add(fish3);

        Fish retreivedFish = filo.get();
        assertSame(retreivedFish, fish3);

        retreivedFish = filo.get();
        assertSame(retreivedFish, fish2);

        retreivedFish = filo.get();
        assertSame(retreivedFish, fish1);
    }
}
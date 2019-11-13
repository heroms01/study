package designpattern.factory.logistics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogisticsTest {

    @Test
    void planDelivery() {
        Logistics logistics = new RoadLogistics();
        logistics.planDelivery();
    }
}

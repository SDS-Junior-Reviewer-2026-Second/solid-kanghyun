package vehicle;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VehicleTest {
    @Test
    public void test_sample() {
        Vehicle vehicle = new Vehicle(10);
        assertEquals(10, vehicle.getRemainingFuel()); 
    }
}

package house;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PenthouseSuiteTest {
    @Test
    public void testInitializedWithFourBedrooms() {
        PenthouseSuite penthouse = new PenthouseSuite();
        assertEquals(4, penthouse.numberOfBedrooms);
    }

    @Test
    public void testSetsSquareFootage() {
        PenthouseSuite penthouse = new PenthouseSuite();
        penthouse.setSquareFootage(1500);
        assertEquals(1500, penthouse.squareFootage);
    }

    @Test
    public void testUpgradeBedroomNumberAddsOneBedroom() {
        PenthouseSuite penthouse = new PenthouseSuite();
        penthouse.upgradeBedroomNumber();
        assertEquals(5, penthouse.numberOfBedrooms);
    }
}

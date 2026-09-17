package house;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnitUpgraderTest {
    @Test
    public void testUpgraderIncreasesSquareFootageOfPenthouse() {
        PenthouseSuite penthouse = new PenthouseSuite();
        penthouse.setSquareFootage(1500);
        UnitUpgrader upgrader = new UnitUpgrader();
        upgrader.upgrade(penthouse);

        assertEquals(1540, penthouse.squareFootage);
    }

    @Test
    public void testUpgraderAddsBedroomToApartment() {
        PenthouseSuite penthouse = new PenthouseSuite();
        UnitUpgrader upgrader = new UnitUpgrader();
        upgrader.upgrade(penthouse);

        assertEquals(5, penthouse.numberOfBedrooms);
    }

    @Test
    public void testUpgraderIncreasesSquareFootageOfStudio() {
        Studio studio = new Studio();
        studio.setSquareFootage(550);
        UnitUpgrader upgrader = new UnitUpgrader();
        upgrader.upgrade(studio);

        assertEquals(590, studio.squareFootage);
    }

    @Test
    public void testUpgraderDoesntAddBedroomToStudios() {
        Studio studio = new Studio();
        UnitUpgrader upgrader = new UnitUpgrader();
        upgrader.upgrade(studio);

        assertEquals(0, studio.numberOfBedrooms);
    }

    // LSP: 클라이언트(UnitUpgrader)는 Apartment 타입만 알고도 모든 자식 클래스를 동일하게 다룰 수 있다
    @Test
    public void testUpgraderTreatsAllApartmentsThroughBaseType() {
        Apartment[] apartments = { new PenthouseSuite(), new Studio() };
        UnitUpgrader upgrader = new UnitUpgrader();

        for (Apartment apartment : apartments) {
            apartment.setSquareFootage(1000);
            upgrader.upgrade(apartment);
            assertEquals(1040, apartment.squareFootage);
        }

        assertEquals(5, apartments[0].numberOfBedrooms);
        assertEquals(0, apartments[1].numberOfBedrooms);
    }

    // OCP: 새로운 Apartment 타입이 추가되어도 UnitUpgrader 는 수정할 필요가 없다
    @Test
    public void testUpgraderWorksWithNewApartmentTypeWithoutModification() {
        Apartment duplex = new Apartment() {
            {
                this.numberOfBedrooms = 2;
            }

            @Override
            void upgradeBedroomNumber() {
                this.numberOfBedrooms += 2;
            }
        };
        duplex.setSquareFootage(900);
        UnitUpgrader upgrader = new UnitUpgrader();
        upgrader.upgrade(duplex);

        assertEquals(940, duplex.squareFootage);
        assertEquals(4, duplex.numberOfBedrooms);
    }
}

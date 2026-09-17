package house;

public class PenthouseSuite extends Apartment {
    public PenthouseSuite() {
        this.numberOfBedrooms = 4;
    }

    @Override
    void upgradeBedroomNumber() {
        this.numberOfBedrooms += 1;
    }
}

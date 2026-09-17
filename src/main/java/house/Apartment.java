package house;

abstract class Apartment {
    int squareFootage;
    int numberOfBedrooms;

    public void setSquareFootage(int sqft) {
        this.squareFootage = sqft;
    }

    public void upgradeSquareFootage() {
        this.squareFootage += 40;
    }

    abstract void upgradeBedroomNumber();
}

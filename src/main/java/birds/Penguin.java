package birds;

public class Penguin implements Bird, Swimmable {
    String currentLocation;
    int numberOfFeathers;

    public Penguin(int initialFeatherCount) {
        this.numberOfFeathers = initialFeatherCount;
    }

    @Override
    public void molt() {
        this.numberOfFeathers -= 1;
    }

    @Override
    public void swim() {
        this.currentLocation = "in the water";
    }
}

package house;

public class Studio extends Apartment {
    public Studio() {
        this.numberOfBedrooms = 0;
    }

    // 스튜디오는 침실이 없는 구조이므로 업그레이드해도 침실 개수를 0으로 유지한다
    @Override
    void upgradeBedroomNumber() {
    }
}

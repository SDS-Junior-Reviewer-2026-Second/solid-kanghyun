package birds;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// ISP: 클라이언트는 자신이 실제로 사용하는 작은 인터페이스에만 의존한다
public class BirdClientTest {

    // molt() 만 필요한 클라이언트 → Bird 에만 의존, 날 수 있는지 여부는 알 필요 없다
    static class MoltingSeason {
        void moltAll(Bird... birds) {
            for (Bird bird : birds) {
                bird.molt();
            }
        }
    }

    // fly() 만 필요한 클라이언트 → Flyable 에만 의존, Penguin 은 아예 전달할 수 없다 (컴파일 타임에 차단)
    static class AirShow {
        void launch(Flyable... flyables) {
            for (Flyable flyable : flyables) {
                flyable.fly();
            }
        }
    }

    @Test
    public void testMoltingClientWorksWithEveryBird() {
        Eagle eagle = new Eagle(5);
        Penguin penguin = new Penguin(3);

        new MoltingSeason().moltAll(eagle, penguin);

        assertEquals(4, eagle.numberOfFeathers);
        assertEquals(2, penguin.numberOfFeathers);
    }

    @Test
    public void testFlyingClientWorksWithFlyableOnly() {
        Eagle eagle = new Eagle(5);

        new AirShow().launch(eagle);

        assertEquals("in the air", eagle.currentLocation);
    }
}

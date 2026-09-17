package birds;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EagleTest {
    @Test
    public void testItFliesInTheAir() {
        Eagle eagle = new Eagle(5);
        eagle.fly();
        assertEquals("in the air", eagle.currentLocation);
    }

    @Test
    public void testItLosesFeathers() {
        Eagle eagle = new Eagle(5);
        eagle.molt();
        assertEquals(4, eagle.numberOfFeathers);
    }

    // ISP: Eagle 은 Bird(molt) 와 Flyable(fly) 두 개의 작은 인터페이스를 조합해서 구현한다
    @Test
    public void testItIsBothBirdAndFlyable() {
        Eagle eagle = new Eagle(5);
        assertTrue(eagle instanceof Bird);
        assertTrue(eagle instanceof Flyable);
    }
}

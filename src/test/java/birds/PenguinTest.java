package birds;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PenguinTest {
    @Test
    public void testItLosesFeathers() {
        Penguin penguin = new Penguin(5);
        penguin.molt();
        assertEquals(4, penguin.numberOfFeathers);
    }

    @Test
    public void testItCanSwim() {
        Penguin penguin = new Penguin(5);
        penguin.swim();
        assertEquals("in the water", penguin.currentLocation);
    }

    // ISP: Penguin 은 Flyable 을 구현하지 않으므로 fly() 를 예외로 억지 구현할 필요가 없다
    @Test
    public void testItIsBirdButNotFlyable() {
        Penguin penguin = new Penguin(5);
        assertTrue(penguin instanceof Bird);
        assertTrue(penguin instanceof Swimmable);
        assertFalse((Object) penguin instanceof Flyable);
    }
}

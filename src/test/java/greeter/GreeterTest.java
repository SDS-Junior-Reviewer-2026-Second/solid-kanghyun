package greeter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreeterTest {
    @Test
    public void testSaysHello() {
        Greeter greeter = new Greeter();
        assertEquals("Hello.", greeter.greet());
    }

    @Test
    public void testSaysHelloFormally() {
        Greeter greeter = new Greeter(new FormalGreeting());
        assertEquals("Good evening, sir.", greeter.greet());
    }

    @Test
    public void testSaysHelloCasually() {
        Greeter greeter = new Greeter(new CasualGreeting());
        assertEquals("Sup bro?", greeter.greet());
    }

    @Test
    public void testSaysHelloIntimately() {
        Greeter greeter = new Greeter(new IntimateGreeting());
        assertEquals("Hello Darling!", greeter.greet());
    }

    @Test
    public void testChangesGreetingStrategyAtRuntime() {
        Greeter greeter = new Greeter();
        greeter.setGreetingStrategy(new FormalGreeting());
        assertEquals("Good evening, sir.", greeter.greet());

        greeter.setGreetingStrategy(new CasualGreeting());
        assertEquals("Sup bro?", greeter.greet());
    }

    // OCP: Greeter 수정 없이 새로운 인사 방식을 확장할 수 있다
    @Test
    public void testExtendsWithNewGreetingWithoutModifyingGreeter() {
        GreetingStrategy korean = () -> "안녕하세요.";
        Greeter greeter = new Greeter(korean);
        assertEquals("안녕하세요.", greeter.greet());
    }
}

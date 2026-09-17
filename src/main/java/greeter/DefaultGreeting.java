package greeter;

public class DefaultGreeting implements GreetingStrategy {
    @Override
    public String greet() {
        return "Hello.";
    }
}

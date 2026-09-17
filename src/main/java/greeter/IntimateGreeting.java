package greeter;

public class IntimateGreeting implements GreetingStrategy {
    @Override
    public String greet() {
        return "Hello Darling!";
    }
}

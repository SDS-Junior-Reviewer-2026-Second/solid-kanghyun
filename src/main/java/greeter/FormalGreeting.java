package greeter;

public class FormalGreeting implements GreetingStrategy {
    @Override
    public String greet() {
        return "Good evening, sir.";
    }
}

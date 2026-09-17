package greeter;

public class Greeter {
    private GreetingStrategy greetingStrategy;

    public Greeter() {
        this(new DefaultGreeting());
    }

    public Greeter(GreetingStrategy greetingStrategy) {
        this.greetingStrategy = greetingStrategy;
    }

    public String greet() {
        return greetingStrategy.greet();
    }

    public void setGreetingStrategy(GreetingStrategy greetingStrategy) {
        this.greetingStrategy = greetingStrategy;
    }
}

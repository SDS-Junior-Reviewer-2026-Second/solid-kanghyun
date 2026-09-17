package greeter;

public class CasualGreeting implements GreetingStrategy {
    @Override
    public String greet() {
        return "Sup bro?";
    }
}

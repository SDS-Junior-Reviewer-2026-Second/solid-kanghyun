package weather;

import java.util.HashMap;
import java.util.Map;

public class WeatherTracker {
    String currentConditions;
    private final Map<String, Notifier> notifiers;

    public WeatherTracker() {
        this(new HashMap<>());
        register("rainy", new Phone());
        register("sunny", new Email());
    }

    public WeatherTracker(Map<String, Notifier> notifiers) {
        this.notifiers = new HashMap<>(notifiers);
    }

    public void register(String weatherConditions, Notifier notifier) {
        notifiers.put(weatherConditions, notifier);
    }

    public void setCurrentConditions(String weatherDescription) {
        this.currentConditions = weatherDescription;

        Notifier notifier = notifiers.get(weatherDescription);
        if (notifier != null) {
            String alert = notifier.generateWeatherAlert(weatherDescription);
            System.out.print(alert);
        }
    }
}

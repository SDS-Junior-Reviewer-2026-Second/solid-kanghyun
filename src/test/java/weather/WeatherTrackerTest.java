package weather;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WeatherTrackerTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @AfterEach
    public void restoreStdout() {
        System.setOut(originalOut);
    }

    @Test
    public void testReturnsCurrentWeather() {
        WeatherTracker tracker = new WeatherTracker();
        tracker.setCurrentConditions("rainy");

        assertEquals("rainy", tracker.currentConditions);
    }

    @Test
    public void testAlertsPhoneUsersWhenRaining() {
        WeatherTracker tracker = new WeatherTracker();
        System.setOut(new PrintStream(outContent));
        tracker.setCurrentConditions("rainy");

        assertEquals("It is rainy", outContent.toString());
    }

    @Test
    public void testAlertsViaEmailWhenSunny() {
        WeatherTracker tracker = new WeatherTracker();
        System.setOut(new PrintStream(outContent));
        tracker.setCurrentConditions("sunny");

        assertEquals("It is sunny", outContent.toString());
    }

    // DIP: WeatherTracker 는 Notifier 추상화에만 의존하므로, 진짜 Phone/Email 없이 가짜 Notifier 로 검증할 수 있다
    static class FakeNotifier implements Notifier {
        final List<String> received = new ArrayList<>();

        @Override
        public String generateWeatherAlert(String weatherConditions) {
            received.add(weatherConditions);
            return "";
        }
    }

    @Test
    public void testNotifiesInjectedNotifierForMatchingCondition() {
        FakeNotifier rainyNotifier = new FakeNotifier();
        FakeNotifier sunnyNotifier = new FakeNotifier();
        WeatherTracker tracker = new WeatherTracker(Map.of(
                "rainy", rainyNotifier,
                "sunny", sunnyNotifier));

        tracker.setCurrentConditions("rainy");

        assertEquals(List.of("rainy"), rainyNotifier.received);
        assertTrue(sunnyNotifier.received.isEmpty());
    }

    @Test
    public void testDoesNotNotifyWhenNoNotifierIsRegistered() {
        FakeNotifier notifier = new FakeNotifier();
        WeatherTracker tracker = new WeatherTracker(Map.of("rainy", notifier));

        tracker.setCurrentConditions("cloudy");

        assertEquals("cloudy", tracker.currentConditions);
        assertTrue(notifier.received.isEmpty());
    }

    // DIP + OCP: 새로운 알림 채널이나 날씨 조건을 추가해도 WeatherTracker 는 수정할 필요가 없다
    @Test
    public void testSupportsNewNotifierWithoutModifyingTracker() {
        WeatherTracker tracker = new WeatherTracker();
        Notifier slack = conditions -> "[slack] It is " + conditions;
        tracker.register("snowy", slack);
        System.setOut(new PrintStream(outContent));

        tracker.setCurrentConditions("snowy");

        assertEquals("[slack] It is snowy", outContent.toString());
    }
}

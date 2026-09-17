package weather;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmailTest {
    @Test
    public void testGeneratesAlertString() {
        Email email = new Email();
        assertEquals("It is sunny", email.generateWeatherAlert("sunny"));
    }
}

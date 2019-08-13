package salestaxes.test.rows;

import org.junit.Test;
import salestaxes.rows.PriceString;

import static org.junit.Assert.assertEquals;

public class PriceStringTest {

    @Test
    public void shows_two_decimals() {
        String formattedPrice = PriceString.from(10.0);

        assertEquals("10.00", formattedPrice);

        formattedPrice = PriceString.from(10.000);

        assertEquals("10.00", formattedPrice);
    }

    @Test
    public void rounds_up() {
        String formattedPrice = PriceString.from(10.999);

        assertEquals("11.00", formattedPrice);
    }

    @Test
    public void rounds_down() {
        String formattedPrice = PriceString.from(10.001);

        assertEquals("10.00", formattedPrice);
    }

}
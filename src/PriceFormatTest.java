import org.junit.Test;

import static org.junit.Assert.*;

public class PriceFormatTest {

    @Test
    public void shows_two_decimals() {
        String formattedPrice = PriceFormat.getFor(10.0);

        assertEquals("10.00", formattedPrice);

        formattedPrice = PriceFormat.getFor(10.000);

        assertEquals("10.00", formattedPrice);
    }

    @Test
    public void rounds_up() {
        String formattedPrice = PriceFormat.getFor(10.999);

        assertEquals("11.00", formattedPrice);
    }

    @Test
    public void rounds_down() {
        String formattedPrice = PriceFormat.getFor(10.001);

        assertEquals("10.00", formattedPrice);
    }

}
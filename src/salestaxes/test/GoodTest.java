package salestaxes.test;

import org.junit.Test;
import salestaxes.Good;
import salestaxes.GoodType;

import static junit.framework.TestCase.assertEquals;

public class GoodTest {

    @Test
    public void name_is_passed_as_argument() {
        Good good = new Good("good name", 10.0, GoodType.OTHER);

        assertEquals("good name", good.name());
    }

    @Test
    public void price_is_passed_as_argument() {
        Good good = new Good("good name", 10.0, GoodType.OTHER);

        assertEquals(10.0, good.price());
    }

    @Test
    public void type_is_passed_as_argument() {
        Good good = new Good("good name", 10.0, GoodType.OTHER);

        assertEquals(GoodType.OTHER, good.type());
    }

}
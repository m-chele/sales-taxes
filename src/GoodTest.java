import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class GoodTest {

    @Test
    public void name_is_passed_as_argument() {
        Good good = new Good("good name", 10.0, null);

        assertEquals("good name", good.name());
    }

    @Test
    public void price_is_passed_as_argument() {
        Good good = new Good("good name", 10.0, price -> 0.0);

        assertEquals(10.0, good.taxedPrice());
    }

}
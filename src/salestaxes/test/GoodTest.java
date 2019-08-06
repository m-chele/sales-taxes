package salestaxes.test;

import org.junit.Test;
import salestaxes.Good;
import salestaxes.GoodType;

import java.util.Arrays;
import java.util.Collections;

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
    public void types_are_a_list() {
        Good good = new Good("good name", 10.0, GoodType.OTHER);

        assertEquals(Collections.singletonList(GoodType.OTHER), good.types());
    }

    @Test
    public void one_element_for_each_passed_type() {
        Good good = new Good("good name", 10.0, GoodType.OTHER, GoodType.BOOK);

        assertEquals(Arrays.asList(GoodType.OTHER, GoodType.BOOK), good.types());
    }

}
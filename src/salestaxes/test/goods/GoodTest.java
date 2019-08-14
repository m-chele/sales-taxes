package salestaxes.test.goods;

import org.junit.Test;
import salestaxes.goods.Good;
import salestaxes.test.doubles.TestGoodType;

import java.util.Arrays;
import java.util.Collections;

import static junit.framework.TestCase.assertEquals;

public class GoodTest {

    @Test
    public void name_is_passed_as_argument() {
        Good good = new Good("good name", 10.0, TestGoodType.ANY);

        assertEquals("good name", good.name());
    }

    @Test
    public void price_is_passed_as_argument() {
        Good good = new Good("good name", 10.0, TestGoodType.ANY);

        assertEquals(10.0, good.price());
    }

    @Test
    public void types_are_a_list() {
        Good good = new Good("good name", 10.0, TestGoodType.ANY);

        assertEquals(Collections.singletonList(TestGoodType.ANY), good.types());
    }

    @Test
    public void one_element_for_each_passed_type() {
        Good good = new Good("good name", 10.0, TestGoodType.ANY, TestGoodType.ANY);

        assertEquals(Arrays.asList(TestGoodType.ANY, TestGoodType.ANY), good.types());
    }

}
package salestaxes.test;

import org.junit.Test;
import salestaxes.Total;

import static junit.framework.TestCase.assertEquals;

public class TotalTest {

    @Test
    public void initial_amount_is_0() {
        Total total = new Total();

        assertEquals(0.0, total.get());
    }

    @Test
    public void amount_is_66_if_I_add_66() {
        Total total = new Total();

        total.add(66.0);

        assertEquals(66.0, total.get());
    }

    @Test
    public void amount_is_66_if_I_add_36_and_30() {
        Total total = new Total();

        total.add(36.0);
        total.add(30.0);

        assertEquals(66.0, total.get());
    }

}

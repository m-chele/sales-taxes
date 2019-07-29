package salestaxes.test;

import org.junit.Test;
import salestaxes.TotalAmount;

import static junit.framework.TestCase.assertEquals;

public class TotalAmountTest {

    @Test
    public void initial_amount_is_0() {
        TotalAmount total = new TotalAmount();

        assertEquals(0.0, total.get());
    }

    @Test
    public void amount_is_66_if_I_add_66() {
        TotalAmount total = new TotalAmount();

        total.add(66.0);

        assertEquals(66.0, total.get());
    }

    @Test
    public void amount_is_66_if_I_add_36_and_30() {
        TotalAmount total = new TotalAmount();

        total.add(36.0);
        total.add(30.0);

        assertEquals(66.0, total.get());
    }

}

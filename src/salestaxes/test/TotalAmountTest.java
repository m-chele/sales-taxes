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

}

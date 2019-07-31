package salestaxes.test;

import org.junit.Test;
import salestaxes.Good;
import salestaxes.GoodType;
import salestaxes.Taxes;

import static junit.framework.TestCase.assertEquals;

public class TaxesTest {

    @Test
    public void applies_a_single_tax() {
        Taxes taxes = new Taxes();

        Good good = new Good("something", 10.0, GoodType.OTHER);

        assertEquals(1.0, taxes.calculateFor(good));
    }
}

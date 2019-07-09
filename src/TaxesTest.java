import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TaxesTest {

    @Test
    public void NoTax_does_not_change_the_price() {
        NoTax tax = new NoTax();

        assertEquals(66.66, tax.calculatePrice(66.66));
    }

    @Test
    public void BasicSalesTax_adds_10_percent() {
        BasicSalesTax tax = new BasicSalesTax();

        assertEquals(110.00, tax.calculatePrice(100.00));
    }

}

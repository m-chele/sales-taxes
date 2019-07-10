import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TaxesTest {

    @Test
    public void NoTax_does_not_change_the_price() {
        NoTax tax = new NoTax();

        assertEquals(0.0, tax.taxValue(66.66));
    }

    @Test
    public void BasicSalesTax_is_10_percent() {
        BasicSalesTax tax = new BasicSalesTax();

        assertEquals(10.00, tax.taxValue(100.00));
    }

}

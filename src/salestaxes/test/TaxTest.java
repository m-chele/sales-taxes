package salestaxes.test;

import org.junit.Test;
import salestaxes.GoodType;
import salestaxes.taxes.BasicSalesTax;
import salestaxes.taxes.ImportTax;
import salestaxes.taxes.NoTax;

import java.util.Collections;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class TaxTest { // TODO: refactor, extract in single test file

    @Test
    public void NoTax_applied_to_book() {
        NoTax tax = new NoTax();

        assertTrue(tax.appliesTo(Collections.singletonList(GoodType.BOOK)));
    }

    @Test
    public void NoTax_applied_to_food() {
        NoTax tax = new NoTax();

        assertTrue(tax.appliesTo(Collections.singletonList(GoodType.FOOD)));
    }

    @Test
    public void NoTax_applied_to_medical() {
        NoTax tax = new NoTax();

        assertTrue(tax.appliesTo(Collections.singletonList(GoodType.MEDICAL)));
    }

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

    @Test
    public void BasicSalesTax_applies_to_others() {
        BasicSalesTax tax = new BasicSalesTax();

        assertTrue(tax.appliesTo(Collections.singletonList(GoodType.OTHER)));
        // TODO: not sure this worth
        assertFalse(tax.appliesTo(Collections.singletonList(GoodType.BOOK)));
        assertFalse(tax.appliesTo(Collections.singletonList(GoodType.FOOD)));
        assertFalse(tax.appliesTo(Collections.singletonList(GoodType.MEDICAL)));
    }


    @Test
    public void ImportTax_applies_to_imported() {
        ImportTax tax = new ImportTax();

        assertTrue(tax.appliesTo(Collections.singletonList(GoodType.IMPORTED)));
    }

    @Test
    public void ImportTax_is_5_percent() {
        ImportTax tax = new ImportTax();

        assertEquals(5.00, tax.taxValue(100.00));
    }

}

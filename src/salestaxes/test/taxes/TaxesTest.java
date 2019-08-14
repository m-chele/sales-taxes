package salestaxes.test.taxes;

import org.junit.Test;
import salestaxes.goods.Good;
import salestaxes.goods.GoodType;
import salestaxes.taxes.Round;
import salestaxes.taxes.Tax;
import salestaxes.taxes.Taxes;
import salestaxes.test.doubles.AppliableTax;
import salestaxes.test.doubles.NotAppliableTax;

import static junit.framework.TestCase.assertEquals;

public class TaxesTest {

    private Tax tax10 = new AppliableTax(10);
    private Tax tax20 = new AppliableTax(20);
    private Tax taxNotAppliable = new NotAppliableTax();

    private Round round = new Round();
    private Good good = new Good("something", 10.0, GoodType.OTHER);

    @Test
    public void applies_a_single_tax() {
        Taxes taxes = new Taxes(round, tax10);

        assertEquals(1.0, taxes.calculateFor(good));
    }

    @Test
    public void applies_multiple_taxes() {
        Taxes taxes = new Taxes(round, tax10, tax20);

        assertEquals(3.0, taxes.calculateFor(good));
    }

    @Test
    public void applies_only_right_taxes() {
        Taxes taxes = new Taxes(round, tax10, taxNotAppliable);

        assertEquals(1.0, taxes.calculateFor(good));
    }

}

package salestaxes.test;

import org.junit.Test;
import salestaxes.Good;
import salestaxes.GoodType;
import salestaxes.Taxes;
import salestaxes.taxes.Tax;

import static junit.framework.TestCase.assertEquals;

public class TaxesTest {

    @Test
    public void applies_a_single_tax() {
        Taxes taxes = new Taxes(tax10);

        Good good = new Good("something", 10.0, GoodType.OTHER);

        assertEquals(1.0, taxes.calculateFor(good));
    }

    @Test
    public void applies_multiple_taxes() {
        Taxes taxes = new Taxes(tax10, tax20);

        Good good = new Good("something", 10.0, GoodType.OTHER);

        assertEquals(3.0, taxes.calculateFor(good));
    }

// TODO: refactor
    private Tax tax10 = new Tax() {
        @Override
        public boolean appliesTo(GoodType goodType) {
            return true;
        }

        @Override
        public double taxValue(double price) {
            return price / 10;
        }
    };

    private Tax tax20 = new Tax() {
        @Override
        public boolean appliesTo(GoodType goodType) {
            return true;
        }

        @Override
        public double taxValue(double price) {
            return price / 5;
        }
    };
}

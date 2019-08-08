package salestaxes.test;

import org.junit.Test;
import salestaxes.goods.Good;
import salestaxes.goods.GoodType;
import salestaxes.taxes.Round;
import salestaxes.taxes.Tax;
import salestaxes.taxes.Taxes;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class TaxesTest {

    Round round = new Round();

    @Test
    public void applies_a_single_tax() {
        Taxes taxes = new Taxes(round, tax10);

        Good good = new Good("something", 10.0, GoodType.OTHER);

        assertEquals(1.0, taxes.calculateFor(good));
    }

    @Test
    public void applies_multiple_taxes() {
        Taxes taxes = new Taxes(round, tax10, tax20);

        Good good = new Good("something", 10.0, GoodType.OTHER);

        assertEquals(3.0, taxes.calculateFor(good));
    }

    @Test
    public void applies_only_right_taxes() {
        Taxes taxes = new Taxes(round, tax10, taxNotAppliable);

        Good good = new Good("something", 10.0, GoodType.OTHER);

        assertEquals(1.0, taxes.calculateFor(good));
    }

    private Tax taxWithPercentage(int percentage) {
        return new Tax() {
            @Override
            public boolean appliesTo(List<GoodType> goodTypes) {
                return true;
            }

            @Override
            public double taxValue(double price) {
                return price / (100 / percentage);
            }
        };
    }

    private Tax tax10 = taxWithPercentage(10);
    private Tax tax20 = taxWithPercentage(20);
    private Tax taxNotAppliable = new Tax() {
        @Override
        public boolean appliesTo(List<GoodType> goodTypes) {
            return false;
        }

        @Override
        public double taxValue(double price) {
            return 666;
        }
    };
}

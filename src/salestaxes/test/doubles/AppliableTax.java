package salestaxes.test.doubles;

import salestaxes.goods.GoodTypeInterface;
import salestaxes.taxes.Tax;

import java.util.List;

public class AppliableTax implements Tax {

    private double percentage;

    public AppliableTax(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public boolean appliesTo(List<GoodTypeInterface> goodTypes) {
        return true;
    }

    @Override
    public double taxValue(double price) {
        return price / (100 / percentage);
    }
}

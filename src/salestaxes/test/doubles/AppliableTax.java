package salestaxes.test.doubles;

import salestaxes.goods.GoodType;
import salestaxes.taxes.Tax;

import java.util.List;

public class AppliableTax implements Tax {

    private double percentage;

    public AppliableTax(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public boolean appliesTo(List<GoodType> goodTypes) {
        return true;
    }

    @Override
    public double taxValue(double price) {
        return price / (100 / percentage);
    }
}

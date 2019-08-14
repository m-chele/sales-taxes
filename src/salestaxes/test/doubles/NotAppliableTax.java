package salestaxes.test.doubles;

import salestaxes.goods.GoodType;
import salestaxes.taxes.Tax;

import java.util.List;

public class NotAppliableTax implements Tax {
    @Override
    public boolean appliesTo(List<GoodType> goodTypes) {
        return false;
    }

    @Override
    public double taxValue(double price) {
        return 0;
    }
}

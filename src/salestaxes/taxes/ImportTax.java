package salestaxes.taxes;

import salestaxes.GoodType;

import java.util.List;

public class ImportTax implements Tax {

    @Override
    public boolean appliesTo(List<GoodType> goodTypes) {
        return goodTypes.contains(GoodType.IMPORTED);
    }

    @Override
    public double taxValue(double price) {
        return price / 20;
    }
}

package salestaxes.taxes;

import salestaxes.GoodType;

public class BasicSalesTax implements Tax {

    public boolean appliesTo(GoodType goodType) {
        return GoodType.OTHER.equals(goodType);
    }

    public double taxValue(double price) {
        return price / 10;
    }
}

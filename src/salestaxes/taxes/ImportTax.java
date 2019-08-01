package salestaxes.taxes;

import salestaxes.GoodType;

public class ImportTax implements Tax {

    @Override
    public boolean appliesTo(GoodType goodType) {
        return GoodType.IMPORTED.equals(goodType);
    }

    @Override
    public double taxValue(double price) {
        return price / 20;
    }
}

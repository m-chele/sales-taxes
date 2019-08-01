package salestaxes.taxes;

import salestaxes.GoodType;

public class NoTax implements Tax {

    @Override
    public boolean appliesTo(GoodType goodType) {
        return GoodType.BOOK.equals(goodType) ||
                GoodType.FOOD.equals(goodType) ||
                GoodType.MEDICAL.equals(goodType);
    }

    @Override
    public double taxValue(double price) {
        return 0.0;
    }
}

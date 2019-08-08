package salestaxes.taxes;

import salestaxes.goods.GoodType;

import java.util.List;

public class NoTax implements Tax {

    @Override
    public boolean appliesTo(List<GoodType> goodTypes) {
        return goodTypes.contains(GoodType.BOOK) ||
                goodTypes.contains(GoodType.FOOD) ||
                goodTypes.contains(GoodType.MEDICAL);
    }

    @Override
    public double taxValue(double price) {
        return 0.0;
    }
}

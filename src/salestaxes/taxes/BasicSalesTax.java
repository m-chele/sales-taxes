package salestaxes.taxes;

import salestaxes.goods.GoodType;
import salestaxes.goods.GoodTypeInterface;

import java.util.List;

public class BasicSalesTax implements Tax {

    public boolean appliesTo(List<GoodTypeInterface> goodTypes) {
        return goodTypes.contains(GoodType.OTHER);
    }

    public double taxValue(double price) {
        return price / 10;
    }
}

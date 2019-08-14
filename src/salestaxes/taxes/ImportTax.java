package salestaxes.taxes;

import salestaxes.goods.GoodType;
import salestaxes.goods.GoodTypeInterface;

import java.util.List;

public class ImportTax implements Tax {

    @Override
    public boolean appliesTo(List<GoodTypeInterface> goodTypes) {
        return goodTypes.contains(GoodType.IMPORTED);
    }

    @Override
    public double taxValue(double price) {
        return price / 20;
    }
}

package salestaxes.taxes;

import salestaxes.goods.GoodType;

import java.util.List;

public interface Tax {
    boolean appliesTo(List<GoodType> goodTypes);

    double taxValue(double price);
}

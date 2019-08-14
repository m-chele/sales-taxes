package salestaxes.taxes;

import salestaxes.goods.GoodTypeInterface;

import java.util.List;

public interface Tax {
    boolean appliesTo(List<GoodTypeInterface> goodTypes);

    double taxValue(double price);
}

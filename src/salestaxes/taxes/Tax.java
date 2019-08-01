package salestaxes.taxes;

import salestaxes.GoodType;

public interface Tax {
    boolean appliesTo(GoodType goodType);
    double taxValue(double price);

}

package salestaxes.goods;

import java.util.Arrays;
import java.util.List;

public class Good {
    private final String name;
    private final double price;
    private List<GoodTypeInterface> types;


    public Good(String name, double price, GoodTypeInterface... types) {
        this.name = name;
        this.price = price;
        this.types = Arrays.asList(types);
    }

    public String name() {
        return name;
    }

    public double price() {
        return price;
    }

    public List<GoodTypeInterface> types() {
        return types;
    }
}

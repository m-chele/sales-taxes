package salestaxes;

import salestaxes.taxes.Tax;

public class Good {
    private final String name;
    private final double price;
    private GoodType type;


    private Tax tax;

    public Good(String name, double price, GoodType type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public String name() {
        return name;
    }

    public double price() {
        return price;
    }

    public GoodType type() {
        return type;
    }
}

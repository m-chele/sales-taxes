package salestaxes;

import salestaxes.taxes.Tax;

public class Good {
    private final String name;
    private final double price;
    private GoodType type;


    private Tax tax;

    // TODO: remove
    public Good(String name, double price, Tax tax) {

        this.name = name;
        this.price = price;
        this.tax = tax;
    }

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

    public double taxedPrice() {
        return price + tax.taxValue(price);
    }

    public double taxAmount() {
        return tax.taxValue(price);
    }
}

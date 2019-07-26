package salestaxes;

public class Good {
    private final String name;
    private final double price;
    private Tax tax;

    public Good(String name, double price, Tax tax) {

        this.name = name;
        this.price = price;
        this.tax = tax;
    }

    public String name() {
        return name;
    }

    public double taxedPrice() {
        return price + tax.taxValue(price);
    }

    public double taxAmount() {
        return tax.taxValue(price);
    }
}

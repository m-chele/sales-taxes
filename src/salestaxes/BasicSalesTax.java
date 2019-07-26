package salestaxes;

public class BasicSalesTax implements Tax {

    public double taxValue(double price) {
        return price / 10;
    }
}

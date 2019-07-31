package salestaxes.taxes;

public class ImportTax implements Tax {

    @Override
    public double taxValue(double price) {
        return price / 20;
    }
}

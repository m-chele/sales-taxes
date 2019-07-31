package salestaxes;

import salestaxes.taxes.Tax;

public class Taxes {
    private Tax tax;

    public Taxes(Tax tax) {

        this.tax = tax;
    }

    public double calculateFor(Good good) {
        return tax.taxValue(good.price());
    }
}

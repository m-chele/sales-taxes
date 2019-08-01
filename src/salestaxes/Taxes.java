package salestaxes;

import salestaxes.taxes.Tax;

public class Taxes {
    private Tax[] taxes;

    public Taxes(Tax... taxes) {

        this.taxes = taxes;
    }

    public double calculateFor(Good good) {
        double total = 0.0;

        for(Tax tax : taxes) {
            total += tax.taxValue(good.price());
        }
        return total;
    }
}

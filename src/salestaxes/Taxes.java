package salestaxes;

import salestaxes.taxes.Tax;

public class Taxes {
    private Tax[] taxes;
    private Round round;

    public Taxes(Round round, Tax... taxes) {
        this.round = round;
        this.taxes = taxes;
    }

    public double calculateFor(Good good) {
        double total = 0.0;

        for (Tax tax : taxes) {
            if (tax.appliesTo(good.types())) {
                total += round.round(tax.taxValue(good.price()));
            }
        }
        return total;
    }

}

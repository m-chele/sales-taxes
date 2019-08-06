package salestaxes;

import salestaxes.taxes.Tax;

public class Taxes {
    private Tax[] taxes;

    public Taxes(Tax... taxes) {

        this.taxes = taxes;
    }

    public double calculateFor(Good good) {
        double total = 0.0;

        for (Tax tax : taxes) {
            if (tax.appliesTo(good.types())) {
                total += customRound(tax.taxValue(good.price()));
            }
        }
        return total;
    }

    // TODO: refactor name and position
    private double customRound(double num) {
        return Math.round(num * 20) / 20.0;
    }
}

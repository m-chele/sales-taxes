package salestaxes.rows;

import salestaxes.PriceString;

public class TaxesRow implements Row {
    private double taxesAmount;

    public TaxesRow(double taxesAmount) {
        this.taxesAmount = taxesAmount;
    }

    public String print() {
        if (taxesAmount > 0.0) {
            return "Sales Taxes: " + PriceString.from(taxesAmount) + "\n";
        }
        return "";
    }
}

package salestaxes.rows;

public class TaxesRow implements Row {
    private double taxesAmount;

    public TaxesRow(double taxesAmount) {
        this.taxesAmount = taxesAmount;
    }

    public String print() {
        if (taxesAmount > 0.0) {
            return "\nSales Taxes: " + PriceString.from(taxesAmount);
        }
        return "";
    }
}

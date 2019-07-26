public class TaxesRow {
    private double taxesAmount;

    public TaxesRow(double taxesAmount) {
        this.taxesAmount = taxesAmount;
    }

    public String get() {
        if (taxesAmount > 0.0) {
            return "Sales Taxes: " + PriceString.from(taxesAmount) + "\n";
        }
        return "";
    }
}

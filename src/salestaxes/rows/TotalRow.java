package salestaxes.rows;

import salestaxes.PriceString;

public class TotalRow {
    private double totalAmount;

    public TotalRow(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String get() {
        if (totalAmount > 0.0) {
            return "Total: " + PriceString.from(totalAmount);
        }
        return "";
    }
}

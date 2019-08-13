package salestaxes.rows;

public class TotalRow implements Row {
    private double totalAmount;

    public TotalRow(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String print() {
        if (totalAmount > 0.0) {
            return "\nTotal: " + PriceString.from(totalAmount);
        }
        return "";
    }
}

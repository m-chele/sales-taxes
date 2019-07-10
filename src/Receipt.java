import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private List<Good> goods = new ArrayList();
    private ReceiptRow receiptRow = new ReceiptRow();

    public String output() {
        String goodRows = "";
        double totalReceiptAmount = 0.0;
        double taxesTotalAmount = 0.0;
        for (Good good : goods) {
            goodRows += receiptRow.getFor(good);
            taxesTotalAmount += good.taxAmount();
            totalReceiptAmount += good.taxedPrice();
        }
        if (taxesTotalAmount > 0.0) {
            goodRows += "\n";
            goodRows += "Sales Taxes: " + String.format("%.2f", taxesTotalAmount) + "\n"; // TODO: formattazione duplicata
        }
        if (totalReceiptAmount > 0.0) {
            goodRows += "Total: " + String.format("%.2f", totalReceiptAmount);
        }
        return goodRows;
    }

    public void add(Good good) {

        goods.add(good);
    }
}

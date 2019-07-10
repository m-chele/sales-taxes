import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private List<Good> goods = new ArrayList();
    private ReceiptRow receiptRow = new ReceiptRow();

    public String output() {
        String goodRows = "";
        double taxesTotalAmount = 0.0;
        for (Good good : goods) {
            goodRows += receiptRow.getFor(good);
            taxesTotalAmount += good.taxAmount();
        }
        if (taxesTotalAmount > 0.0) {
            goodRows += "\n";
            goodRows += "Sales Taxes: " + String.format("%.2f", taxesTotalAmount) + "\n"; // TODO: fomrattazione duplicata
        }
        return goodRows;
    }

    public void add(Good good) {

        goods.add(good);
    }
}

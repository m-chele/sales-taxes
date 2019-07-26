package salestaxes;

import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private List<Good> goods = new ArrayList();

    public String output() {
        String receiptRows = "";
        double totalReceiptAmount = 0.0;
        double taxesTotalAmount = 0.0;
        for (Good good : goods) {
            receiptRows += new ReceiptRow(good).get();
            taxesTotalAmount += good.taxAmount();
            totalReceiptAmount += good.taxedPrice();
        }
        receiptRows += "\n";
        receiptRows += new TaxesRow(taxesTotalAmount).get();

        if (totalReceiptAmount > 0.0) {
            receiptRows += "Total: " + PriceString.from(totalReceiptAmount);
        }
        return receiptRows;
    }

    public void add(Good good) {

        goods.add(good);
    }
}

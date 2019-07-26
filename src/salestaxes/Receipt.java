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
            taxesTotalAmount += good.taxAmount(); // TODO: should be totalTaxes.add(good.taxAmount())
            totalReceiptAmount += good.taxedPrice();// TODO: should be totalAmount.add(good.taxedPrice())
        }

        receiptRows += "\n"; // TODO: should be EmptyRow().get()
        receiptRows += new TaxesRow(taxesTotalAmount).get();
        receiptRows += new TotalRow(totalReceiptAmount).get();

        return receiptRows;
    }

    public void add(Good good) {

        goods.add(good);
    }
}

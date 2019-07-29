package salestaxes;

import salestaxes.rows.ReceiptRow;
import salestaxes.rows.TaxesRow;
import salestaxes.rows.TotalRow;

import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private List<Good> goods = new ArrayList();

    public String output() {
        String receiptRows = "";
        TotalAmount totalAmount = new TotalAmount();

        double taxesTotalAmount = 0.0;

        for (Good good : goods) {
            receiptRows += new ReceiptRow(good).get();
            taxesTotalAmount += good.taxAmount(); // TODO: should be totalTaxes.add(good.taxAmount())
            totalAmount.add(good.taxedPrice());
        }

        receiptRows += new EmptyRow().get();
        receiptRows += new TaxesRow(taxesTotalAmount).get();
        receiptRows += new TotalRow(totalAmount.get()).get();

        return receiptRows;
    }

    public void add(Good good) {

        goods.add(good);
    }
}
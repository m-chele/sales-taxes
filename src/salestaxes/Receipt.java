package salestaxes;

import salestaxes.rows.ReceiptRow;
import salestaxes.rows.TaxesRow;
import salestaxes.rows.TotalRow;

import java.util.List;

public class Receipt {
    private List<Good> goods;

    public Receipt(List<Good> goods) {
        this.goods = goods;
    }

    public String output() {
        String receiptRows = "";
        Total totalAmount = new Total();
        Total totalTaxes = new Total();

        for (Good good : goods) {
            receiptRows += new ReceiptRow(good).get();
            totalTaxes.add(good.taxAmount());
            totalAmount.add(good.taxedPrice());
        }

        receiptRows += new EmptyRow().get();
        receiptRows += new TaxesRow(totalTaxes.get()).get();
        receiptRows += new TotalRow(totalAmount.get()).get();

        return receiptRows;
    }

}

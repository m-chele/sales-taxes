package salestaxes;

import salestaxes.rows.ReceiptRow;
import salestaxes.rows.TaxesRow;
import salestaxes.rows.TotalRow;

import java.util.List;

public class Receipt {
    private List<Good> goods;
    private final Total amount;
    private final Total taxes;

    public Receipt(List<Good> goods, Total amount, Total taxes) {
        this.goods = goods;
        this.amount = amount;
        this.taxes = taxes;
    }

    public String output() {
        String output = "";

        for (Good good : goods) {
            output += new ReceiptRow(good).get();
            taxes.add(good.taxAmount());
            amount.add(good.taxedPrice());
        }

        output += new EmptyRow().get();
        output += new TaxesRow(taxes.get()).get();
        output += new TotalRow(amount.get()).get();

        return output;
    }

}

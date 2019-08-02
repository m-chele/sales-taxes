package salestaxes;

import salestaxes.rows.ReceiptRow;
import salestaxes.rows.TaxesRow;
import salestaxes.rows.TotalRow;

import java.util.List;

public class Receipt {
    private List<Good> goods;
    private final Total amount;
    private final Total totalTaxAmount;
    private Taxes taxes;

    public Receipt(List<Good> goods, Total amount, Total totalTaxAmount, Taxes taxes) {
        this.goods = goods;
        this.amount = amount;
        this.totalTaxAmount = totalTaxAmount;
        this.taxes = taxes;
    }

    public String output() {
        String output = "";

        for (Good good : goods) {
            double taxAmount = taxes.calculateFor(good);
            totalTaxAmount.add(taxAmount);
            this.amount.add(good.price() + taxAmount);

            output += new ReceiptRow(good.name(), good.price() + taxAmount).print();
        }

        output += new EmptyRow().get();
        output += new TaxesRow(totalTaxAmount.get()).print();
        output += new TotalRow(amount.get()).print();

        return output;
    }

}

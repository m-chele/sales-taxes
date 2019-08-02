package salestaxes;

import salestaxes.rows.ReceiptRow;
import salestaxes.rows.TaxesRow;
import salestaxes.rows.TotalRow;

import java.util.List;

public class Receipt {
    private List<Good> goods;
    private final Total totalPrice;
    private final Total totalTax;
    private Taxes taxes;

    public Receipt(List<Good> goods, Taxes taxes) {
        this.goods = goods;
        this.totalPrice = new Total();
        this.totalTax = new Total();
        this.taxes = taxes;
    }

    public String output() {
        String output = "";

        for (Good good : goods) {
            double taxAmount = taxes.calculateFor(good);
            totalTax.add(taxAmount);
            double totalPrice = good.price() + taxAmount;
            this.totalPrice.add(totalPrice);

            output += new ReceiptRow(good.name(), totalPrice).print();
        }

        output += new EmptyRow().get();
        output += new TaxesRow(totalTax.get()).print();
        output += new TotalRow(totalPrice.get()).print();

        return output;
    }

}

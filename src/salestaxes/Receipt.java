package salestaxes;

import salestaxes.rows.ReceiptRow;
import salestaxes.rows.Row;
import salestaxes.rows.TaxesRow;
import salestaxes.rows.TotalRow;

import java.util.ArrayList;
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
        List<Row> receiptRows = new ArrayList<>();

        String output = "";

        for (Good good : goods) {
            double taxAmount = taxes.calculateFor(good);
            totalTax.add(taxAmount);
            double totalPrice = good.price() + taxAmount;
            this.totalPrice.add(totalPrice);

            receiptRows.add(new ReceiptRow(good.name(), totalPrice));
        }

        receiptRows.add(new EmptyRow());
        receiptRows.add(new TaxesRow(totalTax.get()));
        receiptRows.add(new TotalRow(totalPrice.get()));

        for (Row row : receiptRows) {
            output += row.print();
        }

        return output;
    }

}

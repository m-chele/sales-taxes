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
    private List<Row> receiptRows;

    public Receipt(List<Good> goods, Taxes taxes) {
        this.goods = goods;
        this.taxes = taxes;
        this.totalPrice = new Total();
        this.totalTax = new Total();
        this.receiptRows = new ArrayList<>();
    }

    public String print() {
        generate();

        return output();
    }

    private String output() {
        String output = "";
        for (Row row : receiptRows) {
            output += row.print();
        }
        return output;
    }

    private void generate() {
        for (Good good : goods) {
            totalTax.add(taxes.calculateFor(good));
            totalPrice.add(totalPriceFor(good));

            receiptRows.add(new ReceiptRow(good.name(), totalPriceFor(good)));
        }

        receiptRows.add(new EmptyRow());
        receiptRows.add(new TaxesRow(totalTax.get()));
        receiptRows.add(new TotalRow(totalPrice.get()));
    }

    private double totalPriceFor(Good good) {
        return good.price() + taxes.calculateFor(good);
    }

}

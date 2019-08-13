package salestaxes;

import salestaxes.goods.Good;
import salestaxes.rows.*;
import salestaxes.taxes.Taxes;

import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private double totalPrice = 0.0;
    private double totalTax = 0.0;
    private Taxes taxes;
    private Display display;
    private List<Row> receiptRows;

    public Receipt(Taxes taxes, Display display) {
        this.taxes = taxes;
        this.display = display;
        this.receiptRows = new ArrayList<>();
    }

    public Receipt build() {
        receiptRows.add(new EmptyRow());
        receiptRows.add(new TaxesRow(totalTax));
        receiptRows.add(new TotalRow(totalPrice));

        return this;
    }

    public void emit() {
        display.showText(output());
    }

    private String output() {
        String output = "";
        for (Row row : receiptRows) {
            output += row.print();
        }
        return output;
    }

    private double totalPriceFor(Good good) {
        return good.price() + taxes.calculateFor(good);
    }

    public Receipt add(Good good) {
        totalTax += taxes.calculateFor(good);
        totalPrice += totalPriceFor(good);

        receiptRows.add(new ReceiptRow(good.name(), totalPriceFor(good)));

        return this;
    }
}

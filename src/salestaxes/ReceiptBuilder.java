package salestaxes;

import salestaxes.goods.Good;
import salestaxes.rows.*;
import salestaxes.taxes.Taxes;

import java.util.ArrayList;
import java.util.List;

public class ReceiptBuilder {
    private double totalPrice = 0.0;
    private double totalTax = 0.0;
    private Taxes taxes;
    private Display display;
    private List<Row> receiptRows;

    public ReceiptBuilder(Taxes taxes, Display display) {
        this.taxes = taxes;
        this.display = display;
        this.receiptRows = new ArrayList<>();
    }

    public void emit() {
        receiptRows.add(new EmptyRow());
        receiptRows.add(new TaxesRow(totalTax));
        receiptRows.add(new TotalRow(totalPrice));

        display.show(receiptRows);
    }

    public ReceiptBuilder add(Good good) {
        totalTax += taxes.calculateFor(good);
        totalPrice += totalPriceFor(good);

        receiptRows.add(new ReceiptRow(good.name(), totalPriceFor(good)));

        return this;
    }

    private double totalPriceFor(Good good) {
        return good.price() + taxes.calculateFor(good);
    }
}

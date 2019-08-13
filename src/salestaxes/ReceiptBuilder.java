package salestaxes;

import salestaxes.goods.Good;
import salestaxes.rows.ReceiptRow;
import salestaxes.rows.Row;
import salestaxes.rows.TaxesRow;
import salestaxes.rows.TotalRow;
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
        addTotalTaxesRow();
        addTotalPriceRow();

        display.show(receiptRows);
    }

    private void addTotalTaxesRow() {
        receiptRows.add(new TaxesRow(totalTax));
    }

    private void addTotalPriceRow() {
        receiptRows.add(new TotalRow(totalPrice));
    }

    public ReceiptBuilder add(Good good) {
        incrementTotalTaxes(good);
        incrementTotalPrice(good);
        addNewRow(good);

        return this;
    }

    private void addNewRow(Good good) {
        receiptRows.add(new ReceiptRow(good.name(), totalPriceFor(good)));
    }

    private void incrementTotalPrice(Good good) {
        totalPrice += totalPriceFor(good);
    }

    private void incrementTotalTaxes(Good good) {
        totalTax += taxes.calculateFor(good);
    }

    private double totalPriceFor(Good good) {
        return good.price() + taxes.calculateFor(good);
    }
}

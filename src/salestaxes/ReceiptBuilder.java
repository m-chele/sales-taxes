package salestaxes;

import salestaxes.goods.Good;
import salestaxes.rows.GoodRow;
import salestaxes.rows.Row;
import salestaxes.rows.TaxesRow;
import salestaxes.rows.TotalRow;
import salestaxes.taxes.Taxes;

import java.util.ArrayList;
import java.util.List;

public class ReceiptBuilder implements ReceiptSetup, ReceiptStep {
    private double totalPrice = 0.0;
    private double totalTax = 0.0;
    private Taxes taxes;
    private Display display;
    private List<Row> receiptRows;

    private ReceiptBuilder() {
        this.receiptRows = new ArrayList<>();
    }

    public static ReceiptSetup init() {
        return new ReceiptBuilder();
    }

    @Override
    public Receipt build() {
        addTotalTaxesRow();
        addTotalPriceRow();

        return new Receipt(display);
    }

    private void addTotalTaxesRow() {
        receiptRows.add(new TaxesRow(totalTax));
    }

    private void addTotalPriceRow() {
        receiptRows.add(new TotalRow(totalPrice));
    }


    @Override
    public ReceiptSetup setDisplay(Display display) {
        this.display = display;
        return this;
    }

    @Override
    public ReceiptSetup setTaxes(Taxes taxes) {
        this.taxes = taxes;
        return this;
    }

    @Override
    public ReceiptStep setupComplete() {
        return this;
    }

    @Override
    public ReceiptBuilder add(Good good) {
        incrementTotalTaxes(good);
        incrementTotalPrice(good);
        addNewRow(good);

        return this;
    }

    private void addNewRow(Good good) {
        receiptRows.add(new GoodRow(good.name(), totalPriceFor(good)));
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


    public class Receipt {

        private Display display;

        public Receipt(Display display) {

            this.display = display;
        }

        public void emit() {
            this.display.show(receiptRows);
        }

    }
}


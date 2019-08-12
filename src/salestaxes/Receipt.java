package salestaxes;

import salestaxes.goods.Good;
import salestaxes.rows.*;
import salestaxes.taxes.Taxes;

import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private List<Good> goods;
    private double totalPrice;
    private double totalTax;
    private Taxes taxes;
    private Display display;
    private List<Row> receiptRows;

    public Receipt(List<Good> goods, Taxes taxes, Display display) {
        this.goods = goods;
        this.taxes = taxes;
        this.display = display;
        this.totalPrice = 0.0;
        this.totalTax = 0.0;
        this.receiptRows = new ArrayList<>();
    }

    public void complete() {
        generate();

        display.showText(output());
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
            totalTax += taxes.calculateFor(good);
            totalPrice += totalPriceFor(good);

            receiptRows.add(new ReceiptRow(good.name(), totalPriceFor(good)));
        }

        receiptRows.add(new EmptyRow());
        receiptRows.add(new TaxesRow(totalTax));
        receiptRows.add(new TotalRow(totalPrice));
    }

    private double totalPriceFor(Good good) {
        return good.price() + taxes.calculateFor(good);
    }

}

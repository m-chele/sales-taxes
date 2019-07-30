package salestaxes.rows;

import salestaxes.Good;
import salestaxes.PriceString;

public class ReceiptRow implements Row {

    private Good good;

    public ReceiptRow(Good good) {

        this.good = good;
    }

    public String print() {
        return "1 "   // TODO: assumiamo che ci sia un solo articolo per tipo
                + good.name()
                + " at "
                + PriceString.from(good.taxedPrice())
                + "\n";
    }
}

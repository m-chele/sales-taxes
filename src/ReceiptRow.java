public class ReceiptRow {

    public String getFor(Good good) {
        return "1 "   // TODO: assumiamo che ci sia un solo articolo per tipo
                + good.name()
                + " at "
                + PriceString.from(good.taxedPrice())
                + "\n";

    }
}

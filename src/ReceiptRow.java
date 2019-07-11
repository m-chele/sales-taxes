public class ReceiptRow {

    public String getFor(Good good) {
        return "1 "   // TODO: assumiamo che ci sia un solo articolo per tipo
                + good.name()
                + " at "
                + PriceFormat.getFor(good.taxedPrice())
                + "\n";

    }
}

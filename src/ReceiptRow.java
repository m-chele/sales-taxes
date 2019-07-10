public class ReceiptRow {

    public String getFor(Good good) {
        return "1 "   // TODO: assumiamo che ci sia un solo articolo per tipo
                + good.name()
                + " at "
                + String.format("%.2f", good.taxedPrice())
                + "\n";

    }
}

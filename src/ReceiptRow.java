public class ReceiptRow {

    private Good good;

    public ReceiptRow(Good good) {

        this.good = good;
    }

    public String get() {
        return "1 "   // TODO: assumiamo che ci sia un solo articolo per tipo
                + good.name()
                + " at "
                + PriceString.from(good.taxedPrice())
                + "\n";
    }
}

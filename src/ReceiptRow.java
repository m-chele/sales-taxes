public class ReceiptRow {

    public String getFor(Good good) {
        return good.name() + " at " + String.format("%.2f", good.price()) + "\n";

    }
}

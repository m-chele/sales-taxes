import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private List<Good> goods = new ArrayList();
    private ReceiptRow receiptRow = new ReceiptRow();

    public String output() {
        String rows = "";
        for (Good good : goods) {
            rows += receiptRow.getFor(good);
        }

        return rows;
    }

    public void add(Good good) {

        goods.add(good);
    }
}

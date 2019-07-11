import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ReceiptRowTest {

    @Test
    public void prints_a_receipt_row_for_a_good() {
        BasicSalesTax tax = new BasicSalesTax();
        Good aGood = new Good("good name", 10, tax);
        ReceiptRow receiptRow = new ReceiptRow(aGood);

        assertEquals("1 good name at 11.00\n", receiptRow.get());
    }

}
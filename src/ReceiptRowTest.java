import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ReceiptRowTest {

    @Test
    public void prints_a_receipt_row_for_a_good() {
        ReceiptRow receiptRow = new ReceiptRow();
        Good aGood = new Good("good name", 10);

        assertEquals("good name at 10.00\n", receiptRow.getFor(aGood));
    }

}
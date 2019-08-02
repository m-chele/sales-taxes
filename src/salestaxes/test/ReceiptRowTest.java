package salestaxes.test;

import org.junit.Test;
import salestaxes.rows.ReceiptRow;

import static junit.framework.TestCase.assertEquals;

public class ReceiptRowTest {

    @Test
    public void prints_a_receipt_row_for_a_good() {

        ReceiptRow receiptRow = new ReceiptRow("good name", 11);

        assertEquals("1 good name at 11.00\n", receiptRow.print());
    }

}
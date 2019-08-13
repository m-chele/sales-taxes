package salestaxes.test.rows;

import org.junit.Test;
import salestaxes.rows.GoodRow;

import static junit.framework.TestCase.assertEquals;

public class GoodRowTest {

    @Test
    public void prints_a_receipt_row_for_a_good() {

        GoodRow goodRow = new GoodRow("good name", 11);

        assertEquals("1 good name at 11.00\n", goodRow.print());
    }

}
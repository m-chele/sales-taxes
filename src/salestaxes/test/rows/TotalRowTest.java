package salestaxes.test.rows;

import org.junit.Test;
import salestaxes.rows.TotalRow;

import static junit.framework.TestCase.assertEquals;

public class TotalRowTest {


    @Test
    public void prints_a_total_amount_row() {
        TotalRow totalRow = new TotalRow(33.33);

        assertEquals("\nTotal: 33.33", totalRow.print());

    }

}

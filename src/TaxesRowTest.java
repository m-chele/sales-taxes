import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TaxesRowTest {

    @Test
    public void prints_a_tax_row_for_a_good() {
        TaxesRow taxesRow = new TaxesRow(33.00);

        assertEquals("Sales Taxes: 33.00\n", taxesRow.get());
    }

}
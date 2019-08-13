package salestaxes.test.rows;

import org.junit.Test;
import salestaxes.rows.TaxesRow;

import static junit.framework.TestCase.assertEquals;

public class TaxesRowTest {

    @Test
    public void prints_a_tax_row_for_a_good() {
        TaxesRow taxesRow = new TaxesRow(33.00);

        assertEquals("\nSales Taxes: 33.00", taxesRow.print());
    }

}
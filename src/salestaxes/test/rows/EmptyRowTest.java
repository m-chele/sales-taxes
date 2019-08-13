package salestaxes.test.rows;

import org.junit.Test;
import salestaxes.rows.EmptyRow;

import static junit.framework.TestCase.assertEquals;

public class EmptyRowTest {

    @Test
    public void prints_an_empty_row() {
        EmptyRow emptyRow = new EmptyRow();

        assertEquals("\n", emptyRow.print());
    }

}

package salestaxes.test;

import org.junit.Test;
import salestaxes.EmptyRow;

import static junit.framework.TestCase.assertEquals;

public class EmptyRowTest {

    @Test
    public void prints_an_empty_row() {
        EmptyRow emptyRow = new EmptyRow();

        assertEquals("\n", emptyRow.get());
    }

}

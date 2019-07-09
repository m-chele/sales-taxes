import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ReceiptTest {

    @Test
    public void one_row_for_each_good() {
        Receipt receipt = new Receipt();
        receipt.add(new Good("good name", 10.0));
        receipt.add(new Good("good name", 10.0));

        String output = receipt.output();

        assertEquals("good name at 10.00\ngood name at 10.00\n", output);
    }

    @Test
    public void empty_result_if_no_goods_added() {
        Receipt receipt = new Receipt();

        String output = receipt.output();

        assertEquals("", output);
    }


}

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ReceiptTest {

    @Test
    public void one_row_for_each_good() {
        Receipt receipt = new Receipt();
        receipt.add(new Good("good name", 10.0));
        receipt.add(new Good("good name", 10.0));

        String result = receipt.calculate();

        assertEquals("good name at 10.00\ngood name at 10.00\n", result);
    }

    @Test
    public void empty_result_if_no_goods_added() {
        Receipt receipt = new Receipt();

        String result = receipt.calculate();

        assertEquals("", result);
    }


}

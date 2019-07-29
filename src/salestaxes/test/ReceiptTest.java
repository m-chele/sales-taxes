package salestaxes.test;

import org.junit.Test;
import salestaxes.Good;
import salestaxes.Receipt;
import salestaxes.taxes.Tax;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class ReceiptTest {

    private Tax NOT_INTERESTING_TAX = price -> 0;

    @Test
    public void one_row_for_each_good() {
        List<Good> goods = Arrays.asList(
                new Good("good name", 10.0, NOT_INTERESTING_TAX),
                new Good("good name", 10.0, NOT_INTERESTING_TAX)
        );
        Receipt receipt = new Receipt(goods);

        String output = receipt.output();

        assertEquals("1 good name at 10.00\n1 good name at 10.00\n\nTotal: 20.00", output);
    }

    @Test
    public void empty_result_if_no_goods_added() {
        Receipt receipt = new Receipt(Collections.emptyList());

        String output = receipt.output();

        assertEquals("\n", output);
    }


}

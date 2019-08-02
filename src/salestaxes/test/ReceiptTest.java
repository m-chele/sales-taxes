package salestaxes.test;

import org.junit.Test;
import salestaxes.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class ReceiptTest {

    @Test
    public void one_row_for_each_good() {
        List<Good> goods = Arrays.asList(
                new Good("good name", 10.0, GoodType.OTHER),
                new Good("good name", 10.0, GoodType.OTHER)
        );
        Taxes taxes = new Taxes();
        Receipt receipt = new Receipt(goods, new Total(), new Total(), taxes);

        String output = receipt.output();

        assertEquals("1 good name at 10.00\n1 good name at 10.00\n\nTotal: 20.00", output);
    }

    @Test
    public void empty_result_if_no_goods_added() {
        Receipt receipt = new Receipt(Collections.emptyList(), new Total(), new Total(), null);

        String output = receipt.output();

        assertEquals("\n", output);
    }


}

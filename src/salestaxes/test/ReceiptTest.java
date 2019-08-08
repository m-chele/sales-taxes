package salestaxes.test;

import org.junit.Test;
import salestaxes.Receipt;
import salestaxes.goods.Good;
import salestaxes.goods.GoodType;
import salestaxes.taxes.Round;
import salestaxes.taxes.Taxes;

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
        Taxes taxes = new Taxes(new Round());
        Receipt receipt = new Receipt(goods, taxes);

        String output = receipt.print();

        assertEquals("1 good name at 10.00\n1 good name at 10.00\n\nTotal: 20.00", output);
    }

    @Test
    public void empty_result_if_no_goods_added() {
        Receipt receipt = new Receipt(Collections.emptyList(), null);

        String output = receipt.print();

        assertEquals("\n", output);
    }


}

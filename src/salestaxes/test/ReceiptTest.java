package salestaxes.test;

import org.junit.Test;
import salestaxes.Display;
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
    String shownText = null;

    @Test
    public void one_row_for_each_good() {
        List<Good> goods = Arrays.asList(
                new Good("good name", 10.0, GoodType.OTHER),
                new Good("good name", 10.0, GoodType.OTHER)
        );
        Taxes taxes = new Taxes(new Round());
        Display testDisplay = text -> shownText = text;

        Receipt receipt = new Receipt(goods, taxes, testDisplay);

        receipt.complete();

        assertEquals("1 good name at 10.00\n1 good name at 10.00\n\nTotal: 20.00", shownText);

    }

    @Test
    public void empty_result_if_no_goods_added() {
        Display testDisplay = text -> shownText = text;
        Receipt receipt = new Receipt(Collections.emptyList(), null, testDisplay);
        receipt.complete();

        assertEquals("\n", shownText);
    }


}

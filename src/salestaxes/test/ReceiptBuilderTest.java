package salestaxes.test;

import org.junit.Test;
import salestaxes.Display;
import salestaxes.ReceiptBuilder;
import salestaxes.goods.Good;
import salestaxes.goods.GoodType;
import salestaxes.taxes.Round;
import salestaxes.taxes.Taxes;

import static junit.framework.TestCase.assertEquals;

public class ReceiptBuilderTest {
    String shownText = null;

    @Test
    public void one_row_for_each_good() {
        Taxes taxes = new Taxes(new Round());
        Display testDisplay = text -> shownText = text;

        ReceiptBuilder receiptBuilder = new ReceiptBuilder(taxes, testDisplay);

        receiptBuilder.add(new Good("good name", 10.0, GoodType.OTHER))
                .add(new Good("good name", 10.0, GoodType.OTHER));

        receiptBuilder
                .build()
                .emit();

        assertEquals("1 good name at 10.00\n1 good name at 10.00\n\nTotal: 20.00", shownText);

    }

    @Test
    public void empty_result_if_no_goods_added() {
        Display testDisplay = text -> shownText = text;
        ReceiptBuilder receiptBuilder = new ReceiptBuilder(null, testDisplay);
        receiptBuilder
                .build()
                .emit();

        assertEquals("\n", shownText);
    }


}

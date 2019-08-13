package salestaxes.test;

import org.junit.Test;
import salestaxes.ReceiptBuilder;
import salestaxes.goods.Good;
import salestaxes.goods.GoodType;
import salestaxes.taxes.Round;
import salestaxes.taxes.Taxes;
import salestaxes.test.doubles.StringDisplay;

import static junit.framework.TestCase.assertEquals;

public class ReceiptBuilderTest {

    StringDisplay testDisplay = new StringDisplay();
    Taxes taxes = new Taxes(new Round());
    ReceiptBuilder receiptBuilder = new ReceiptBuilder(taxes, testDisplay);

    @Test
    public void one_row_for_each_good() {

        receiptBuilder.add(new Good("good name", 10.0, GoodType.OTHER))
                .add(new Good("good name", 10.0, GoodType.OTHER));

        receiptBuilder

                .emit();

        assertEquals("1 good name at 10.00\n1 good name at 10.00\n\nTotal: 20.00", testDisplay.getText());

    }

    @Test
    public void empty_result_if_no_goods_added() {
        receiptBuilder
                .emit();

        assertEquals("", testDisplay.getText());
    }


}

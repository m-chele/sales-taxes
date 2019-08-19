package salestaxes.test;

import org.junit.Before;
import org.junit.Test;
import salestaxes.ReceiptBuilder;
import salestaxes.ReceiptBuilder.Receipt;
import salestaxes.goods.Good;
import salestaxes.taxes.Taxes;
import salestaxes.test.doubles.NoRound;
import salestaxes.test.doubles.StringDisplay;
import salestaxes.test.doubles.TestGoodType;

import static junit.framework.TestCase.assertEquals;

public class ReceiptBuilderTest {

    StringDisplay testDisplay = new StringDisplay();
    Taxes taxes = new Taxes(new NoRound());
    ReceiptBuilder receiptBuilder;

    @Before
    public void setUp() {
        receiptBuilder = new ReceiptBuilder()
                .setDisplay(testDisplay)
                .setTaxes(taxes);
    }

    @Test
    public void one_row_for_each_good() {

        Receipt receipt = receiptBuilder
                .add(new Good("good name", 10.0, TestGoodType.ANY))
                .add(new Good("good name", 20.0, TestGoodType.ANY))
                .build();

        receipt.emit();

        assertEquals("1 good name at 10.00\n1 good name at 20.00\n\nTotal: 30.00", testDisplay.getText());
    }

    @Test
    public void empty_result_if_no_goods_added() {
        Receipt receipt = receiptBuilder.build();

        receipt.emit();

        assertEquals("", testDisplay.getText());
    }


}

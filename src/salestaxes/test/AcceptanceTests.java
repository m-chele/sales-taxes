package salestaxes.test;

import org.junit.Test;
import salestaxes.goods.Good;
import salestaxes.goods.GoodType;
import salestaxes.receipt.ReceiptBuilder;
import salestaxes.receipt.ReceiptBuilder.Receipt;
import salestaxes.taxes.*;
import salestaxes.test.doubles.StringDisplay;

import static junit.framework.TestCase.assertEquals;

public class AcceptanceTests {

    private StringDisplay stringDisplay = new StringDisplay();
    private Taxes taxes = new Taxes(
            new Round0_05(),
            new BasicSalesTax(),
            new ImportTax(),
            new NoTax()
    );


    //    Input 3:
    //        1 imported bottle of perfume at 27.99
    //        1 bottle of perfume at 18.99
    //        1 packet of headache pills at 9.75
    //        1 box of imported chocolates at 11.25
    //
    //    Output 3:
    //        1 imported bottle of perfume: 32.19
    //        1 bottle of perfume: 20.89
    //        1 packet of headache pills: 9.75
    //        1 imported box of chocolates: 11.85
    //
    //    Sales Taxes: 6.70
    //    Total: 74.68
    @Test
    public void input_3() {
        Receipt receipt = ReceiptBuilder.init()
                .setDisplay(stringDisplay)
                .setTaxes(taxes)
                .setupComplete()
                .add(new Good("imported bottle of perfume", 27.99, GoodType.OTHER, GoodType.IMPORTED))
                .add(new Good("bottle of perfume", 18.99, GoodType.OTHER))
                .add(new Good("packet of headache pills", 9.75, GoodType.MEDICAL))
                .add(new Good("imported box of chocolates", 11.25, GoodType.FOOD, GoodType.IMPORTED))
                .build();

        receipt.emit();

        String output1 = "1 imported bottle of perfume at 32.19\n"
                + "1 bottle of perfume at 20.89\n"
                + "1 packet of headache pills at 9.75\n"
                + "1 imported box of chocolates at 11.85\n"
                + "\n"
                + "Sales Taxes: 6.70\n"
                + "Total: 74.68";

        assertEquals(output1, stringDisplay.getText());
    }

    //    Input 2:
    //        1 imported box of chocolates at 10.00
    //        1 imported bottle of perfume at 47.50
    //    Output 2:
    //        1 imported box of chocolates: 10.50
    //        1 imported bottle of perfume: 54.65
    //
    //    Sales Taxes: 7.65
    //    Total: 65.15
    @Test
    public void input_2() {
        Receipt receipt = ReceiptBuilder.init()
                .setDisplay(stringDisplay)
                .setTaxes(taxes)
                .setupComplete()
                .add(new Good("imported box of chocolates", 10.00, GoodType.IMPORTED, GoodType.FOOD))
                .add(new Good("imported bottle of perfume", 47.50, GoodType.OTHER, GoodType.IMPORTED))
                .build();

        receipt.emit();

        String output1 = "1 imported box of chocolates at 10.50\n"
                + "1 imported bottle of perfume at 54.65\n"
                + "\n"
                + "Sales Taxes: 7.65\n"
                + "Total: 65.15";

        assertEquals(output1, stringDisplay.getText());
    }


    //    Input 1:
    //        1 book at 12.49
    //        1 music CD at 14.99
    //        1 chocolate bar at 0.85
    @Test
    public void input_1() {
        Receipt receipt = ReceiptBuilder.init()
                .setDisplay(stringDisplay)
                .setTaxes(taxes)
                .setupComplete()
                .add(new Good("book", 12.49, GoodType.BOOK))
                .add(new Good("music CD", 14.99, GoodType.OTHER))
                .add(new Good("chocolate bar", 0.85, GoodType.FOOD))
                .build();

        receipt.emit();

        String output1 = "1 book at 12.49\n"
                + "1 music CD at 16.49\n"
                + "1 chocolate bar at 0.85\n"
                + "\n"
                + "Sales Taxes: 1.50\n"
                + "Total: 29.83";

        assertEquals(output1, stringDisplay.getText());
    }
}

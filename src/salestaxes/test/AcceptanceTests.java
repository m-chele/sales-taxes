package salestaxes.test;

import org.junit.Test;
import salestaxes.Good;
import salestaxes.Receipt;
import salestaxes.taxes.BasicSalesTax;
import salestaxes.taxes.NoTax;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class AcceptanceTests {

    @Test
    public void input_1() {
//        Input 1:
//        1 book at 12.49
//        1 music CD at 14.99
//        1 chocolate bar at 0.85
        List<Good> goods = Arrays.asList(
                new Good("book", 12.49, new NoTax()),
                new Good("music CD", 14.99, new BasicSalesTax()),
                new Good("chocolate bar", 0.85, new NoTax())
        );

        Receipt receipt = new Receipt(goods);

        String output1 = "1 book at 12.49\n"
                + "1 music CD at 16.49\n"
                + "1 chocolate bar at 0.85\n"
                + "\n"
                + "Sales Taxes: 1.50\n"
                + "Total: 29.83";

        assertEquals(output1, receipt.output());
    }

    //    Input 2:
//            1 imported box of chocolates at 10.00
//            1 imported bottle of perfume at 47.50
//
//    Input 3:
//            1 imported bottle of perfume at 27.99
//            1 bottle of perfume at 18.99
//            1 packet of headache pills at 9.75
//            1 box of imported chocolates at 11.25
//
//    OUTPUT
//    Output 1:
//            1 book : 12.49
//            1 music CD: 16.49
//            1 chocolate bar: 0.85
//
//    Sales Taxes: 1.50
//    Total: 29.83
//
//    Output 2:
//            1 imported box of chocolates: 10.50
//            1 imported bottle of perfume: 54.65
//    Sales Taxes: 7.65
//    Total: 65.15
//
//    Output 3:
//            1 imported bottle of perfume: 32.19
//            1 bottle of perfume: 20.89
//            1 packet of headache pills: 9.75
//            1 imported box of chocolates: 11.85
//
//    Sales Taxes: 6.70
//    Total: 74.68
//    @Test
//    public void input_2() {
//        Receipt receipt = new Receipt();
//
//        receipt.add(new Good("book", 12.49, new NoTax()));
//        receipt.add(new Good("music CD", 14.99, new BasicSalesTax()));
//        receipt.add(new Good("chocolate bar", 0.85, new NoTax()));
//
//    }
//
//    @Test
//    public void input_3() {
//        Receipt receipt = new Receipt();
//
//        receipt.add(new Good("book", 12.49, new NoTax()));
//        receipt.add(new Good("music CD", 14.99, new BasicSalesTax()));
//        receipt.add(new Good("chocolate bar", 0.85, new NoTax()));
//
//    }
}

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CosoDiTest {

    @Test
    public void empty_result_if_no_goods_added() {
        Receipt receipt = new Receipt();

        String result = receipt.calculate();

        assertEquals("", result);
    }


}

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class GoodTest {

    @Test
    public void default_good_name() {
        Good good = new Good();

        assertEquals("good name", good.name());
    }

}
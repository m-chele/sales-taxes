package salestaxes.test.taxes;


import org.junit.Test;
import salestaxes.taxes.Round;

import static junit.framework.TestCase.assertEquals;

public class RoundTest {

    @Test
    public void rounds_up_to_0_05() {
        Round round005 = new Round();
        assertEquals(0.00, round005.round(0.00));
        assertEquals(0.05, round005.round(0.04));
        assertEquals(0.6, round005.round(0.5625));
        assertEquals(0.1, round005.round(0.06));
        assertEquals(1.45, round005.round(1.449));
        assertEquals(1.5, round005.round(1.465));
    }

}

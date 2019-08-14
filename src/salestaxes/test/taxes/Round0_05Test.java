package salestaxes.test.taxes;


import org.junit.Test;
import salestaxes.taxes.Round0_05;

import static junit.framework.TestCase.assertEquals;

public class Round0_05Test {

    @Test
    public void rounds_up_to_0_05() {
        Round0_05 round005 = new Round0_05();
        assertEquals(0.00, round005.round(0.00));
        assertEquals(0.05, round005.round(0.04));
        assertEquals(0.6, round005.round(0.5625));
        assertEquals(0.1, round005.round(0.06));
        assertEquals(1.45, round005.round(1.449));
        assertEquals(1.5, round005.round(1.465));
    }

}

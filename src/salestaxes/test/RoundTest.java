package salestaxes.test;


import org.junit.Test;
import salestaxes.Round;

import static junit.framework.TestCase.assertEquals;

public class RoundTest {

    @Test
    public void rounds_up_to_005() {
        Round round005 = new Round();
        assertEquals(0.05, round005.round(0.04));
        assertEquals(1.45, round005.round(1.449));
    }

    @Test
    public void rounds_down_to_005() {
        Round round005 = new Round();
        assertEquals(0.05, round005.round(0.06));
        assertEquals(1.45, round005.round(1.465));
    }


}

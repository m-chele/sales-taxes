package salestaxes.test.doubles;

import salestaxes.taxes.Round;

public class NoRound implements Round {

    @Override
    public double round(double value) {
        return value;
    }
}

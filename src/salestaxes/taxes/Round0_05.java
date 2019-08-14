package salestaxes.taxes;

public class Round0_05 implements Round {

    public double round(double value) {
        return Math.ceil(value * 20) / 20.0;
    }
}

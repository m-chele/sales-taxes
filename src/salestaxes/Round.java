package salestaxes;


public class Round {

    public double round(double value) {
        return Math.ceil(value * 20) / 20.0;

    }
}

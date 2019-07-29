package salestaxes;

public class Total {

    private double amount = 0;

    public double get() {
        return amount;
    }

    public void add(double amount) {
        this.amount += amount;
    }
}

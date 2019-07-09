public class Good {
    private final String name;
    private final double price;

    public Good(String name, double price) {

        this.name = name;
        this.price = price;
    }

    public String name() {
        return name;
    }

    public double price() {
        return price;
    }
}

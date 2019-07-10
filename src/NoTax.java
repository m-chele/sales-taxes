public class NoTax implements Tax {
    @Override
    public double taxValue(double price) {
        return 0.0;
    }
}

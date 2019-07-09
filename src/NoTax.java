public class NoTax implements Tax {
    @Override
    public double calculatePrice(double price) {
        return price;
    }
}

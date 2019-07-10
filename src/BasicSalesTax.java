public class BasicSalesTax implements Tax {

    public double calculatePrice(double price) {
        return price + price / 10;
    }
}

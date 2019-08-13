package salestaxes.rows;

public class GoodRow implements Row {

    private final String goodName;
    private final double totalPrice;

    public GoodRow(String goodName, double totalPrice) {

        this.goodName = goodName;
        this.totalPrice = totalPrice;
    }

    public String print() {
        return "1 "   // TODO: assumiamo che ci sia un solo articolo per tipo
                + goodName
                + " at "
                + PriceString.from(totalPrice)
                + "\n";
    }
}

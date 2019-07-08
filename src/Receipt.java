public class Receipt {
    private Good good;

    public String calculate() {

        if(null != good)
            return good.name();

        return "";
    }

    public void add(Good good) {

        this.good = good;
    }
}

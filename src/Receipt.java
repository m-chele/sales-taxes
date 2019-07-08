import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private List<Good> goods = new ArrayList();

    public String calculate() {
        String result = "";
        for (Good g : goods) {
            result += g.name() + "\n";
        }

        return result;
    }

    public void add(Good good) {

        goods.add(good);
    }
}

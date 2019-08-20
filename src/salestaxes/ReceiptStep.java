package salestaxes;

import salestaxes.ReceiptBuilder.Receipt;
import salestaxes.goods.Good;

public interface ReceiptStep {
    ReceiptStep add(Good good);

    Receipt build();
}

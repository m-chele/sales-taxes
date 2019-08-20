package salestaxes;

import salestaxes.ReceiptBuilder.Receipt;
import salestaxes.goods.Good;

public interface ReceiptBuilderStep {
    ReceiptBuilderStep add(Good good);

    Receipt build();
}

package salestaxes.receipt;

import salestaxes.goods.Good;
import salestaxes.receipt.ReceiptBuilder.Receipt;

public interface ReceiptBuilderStep {
    ReceiptBuilderStep add(Good good);

    Receipt build();
}

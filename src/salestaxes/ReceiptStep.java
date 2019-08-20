package salestaxes;

import salestaxes.goods.Good;

public interface ReceiptStep {
    ReceiptStep add(Good good);

    ReceiptBuilder.Receipt build();
}

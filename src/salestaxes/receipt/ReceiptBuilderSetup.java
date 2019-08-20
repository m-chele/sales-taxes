package salestaxes.receipt;

import salestaxes.Display;
import salestaxes.taxes.Taxes;

public interface ReceiptBuilderSetup {
    ReceiptBuilderSetup setDisplay(Display display);

    ReceiptBuilderSetup setTaxes(Taxes taxes);

    ReceiptBuilderStep setupComplete();
}

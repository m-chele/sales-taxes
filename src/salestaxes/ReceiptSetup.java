package salestaxes;

import salestaxes.taxes.Taxes;

public interface ReceiptSetup {
    ReceiptSetup setDisplay(Display display);

    ReceiptSetup setTaxes(Taxes taxes);

    ReceiptStep setupComplete();
}

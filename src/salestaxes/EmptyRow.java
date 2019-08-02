package salestaxes;

import salestaxes.rows.Row;

public class EmptyRow implements Row {

    @Override
    public String print() {
        return "\n";
    }
}

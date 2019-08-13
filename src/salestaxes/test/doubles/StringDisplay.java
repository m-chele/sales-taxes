package salestaxes.test.doubles;

import salestaxes.Display;
import salestaxes.rows.Row;

import java.util.List;

public class StringDisplay implements Display {

    private String output = "";

    @Override
    public void show(List<Row> receiptRows) {

        for (Row row : receiptRows) {
            output += row.print();
        }
    }

    public String getText() {
        return output;
    }

}

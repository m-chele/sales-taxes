package salestaxes.test.doubles;

import salestaxes.Display;

public class StringDisplay implements Display {

    private String text;

    public String getText() {
        return text;
    }

    @Override
    public void showText(String text) {
        this.text = text;
    }


}

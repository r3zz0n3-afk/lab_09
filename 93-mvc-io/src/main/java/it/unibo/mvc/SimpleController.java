package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 
 *
 */
public final class SimpleController implements Controller {

    private String curreString;
    private final List<String> historyStrings;

    SimpleController() {
        historyStrings = new ArrayList<>();
    }

    @Override
    public List<String> getHisotryPrintedString() {
        return List.copyOf(this.historyStrings);
    }

    @Override
    public String getNexString() {
        return curreString;
    }

    @Override
    public void printCurentString() {
        if (this.curreString == null) {
            throw new IllegalStateException("The string is not setted");
        }
        System.out.println("Current String: " + curreString); //NOPMD
    }

    @Override
    public void setNextStringToPrint(final String s) {
        curreString = Objects.requireNonNull(s);
        historyStrings.add(s);
    }

}

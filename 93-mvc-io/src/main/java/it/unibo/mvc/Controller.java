package it.unibo.mvc;

import java.util.List;

/**
 * A simple controller responsible of I/O access.
 * It considers only the standard output, and it is able to print on it.
 */
public interface Controller {

    /**
     * A method for setting the next string to print.
     * 
     * @param s string that write the user in text field.
     * @throws NullPointerException Null values are not acceptable.
     */
    void setNextStringToPrint(String s);

    /**
     * A method that return the current string.
     * 
     * @return the current string that setted.
     */
    String getNexString();

    /**
     * @return list that contains all string printed in std output.
     */
    List<String> getHisotryPrintedString();

    /**
     * A method that prints the current string.
     * 
     * @throws IllegalStateException If the current string is unset.
     */
    void printCurentString();

}

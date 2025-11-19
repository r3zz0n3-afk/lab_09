package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public final class Controller {
    private File file = new File(System.getProperty("user.home") + File.separator + "output" + ".txt");

    /**
     *  Method that should set the new file that slected.
     * 
     * @param newFile is the file that selcet from user
     */
    public void setNewFile(final File newFile) {
        file = newFile;
    }

    /**
     * Method that use for discore the path of current file.
     * 
     * @return current path file
     */
    public String getPathFile() {
        return file.getPath();
    } 

    /**
     * Method that use for write in to current file.
     * 
     * @param input content fo textArea
     * @throws IOException if can not possibile to write in the file
     */
    public void writeToFile(final String input) throws IOException {
        try (
                PrintStream wPrintStream = new PrintStream(this.getFile(), StandardCharsets.UTF_8);
            ) {
                wPrintStream.println(input);
            }
    }

    /**
     * Method tha return the current file.
     * 
     * @return {@File}
     */
    public File getFile() {
        return file;
    }
}

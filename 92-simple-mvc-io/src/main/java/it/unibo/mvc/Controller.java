package it.unibo.mvc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private File file = new File(System.getProperty("user.home") + File.separator + "output" + ".txt" );

    public void setNewFile(final File newFile) {
        file = newFile;
    }

    public String getPathFile() {
        return file.getPath();
    } 

    public void writeToFile(String input) throws IOException {
        try (
            BufferedWriter writerFile = new BufferedWriter(
                    new OutputStreamWriter(
                        new FileOutputStream(this.getPathFile()), StandardCharsets.UTF_16
                    )
                )
            ) {
            for (char c : input.toCharArray())  {
                if ( c != '\n') {
                    writerFile.write(c);
                } else {
                    writerFile.newLine();
                }
            }
        }
       
    }

    public File getFile() {
        return file;
    }
}

package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    private File currentFile;
 
    /**
     * Creates a new Controller.
     */
    public Controller() {
    final String path = System.getProperty("user.home") + File.separator + "Output.txt";
    currentFile = new File(path);
    }

    /**
     * This method set a File as current file.
     *
     * @param file is the file for insert a text
     */
    void setFile(final File file) {
        this.currentFile = file;
    }

    /**
     * This method return the current file.
     *
     * @return the current file
     */
    File getFile() {
        return this.currentFile;
    }

    /**
     * This method return the path of the current file.
     *
     * @return the current path
     */
    String getPath() {
        return this.currentFile.getPath();
    }

    /**
     * This method take a String as input and save its content on the current file.
     *
     * @param write the text to write
     * @throws IOException if the write doesen't work
     */
    void writeOnFile(final String write) throws IOException {
        try (PrintStream ps = new PrintStream(currentFile, StandardCharsets.UTF_8)) {
        ps.print(write);
        }
    }
}

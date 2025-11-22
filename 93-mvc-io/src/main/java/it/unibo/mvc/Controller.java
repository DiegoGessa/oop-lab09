package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {

    /**
     * set a string as next string.
     * 
     * @param string next string to save
     */
    void setNextString(String string);

    /**
     * get the next string.
     * 
     * @return String
     */
    String getNextString();

    /**
     * get the history of the strings.
     * 
     * @return List of all strings
     */
    List<String> getHistory();

    /**
     * print the current string.
     */
    void printCurrentString();
}

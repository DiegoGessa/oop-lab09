package it.unibo.mvc;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * 
 *
 */
public final class SimpleController implements Controller {
    private String next;
    private final List<String> list;

    /**
     * Create a new SimpleController.
     */
    public SimpleController() {
        list = new LinkedList<>();
    }

    @Override
    public void setNextString(final String string) {
        Objects.requireNonNull(string);
        this.next = string;
    }

    @Override
    public String getNextString() {
        return this.next;
    }

    @Override
    public List<String> getHistory() {
        return List.copyOf(list);
    }

    @Override
    public void printCurrentString() {
        if (next == null) {
            throw new IllegalStateException("The next string is null");
        }
        System.out.println(this.next); //NOPMD
        list.add(this.next);
    }

}

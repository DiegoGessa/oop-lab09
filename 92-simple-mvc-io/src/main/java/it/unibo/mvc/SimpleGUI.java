package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.BorderLayout;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {
    private static final int PROPORTION = 5;
    private final JFrame frame = new JFrame();

    /**
     * Create a new SimpleGUI.
     */
    public SimpleGUI() {
    final JPanel panel = new JPanel(new BorderLayout());
    final JTextArea area = new JTextArea();
    final JButton button = new JButton("Save");
    final Controller controller = new Controller();

        panel.add(area, BorderLayout.CENTER);
        panel.add(button, BorderLayout.SOUTH);
        frame.setTitle("My first graphical inteface");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent event) {
                try {
                    controller.writeOnFile(area.getText());

                } catch (final IOException e) {
                    e.printStackTrace(); //NOPMD:is for an exercise
                }
            }
        });
    }

/**
 * This method take the size of the screen and show the GUI.
 */
private void display() {
    final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    final int sw = (int) screen.getWidth();
    final int sh = (int) screen.getHeight();
    frame.setSize(sw / PROPORTION, sh / PROPORTION);
    frame.setLocationByPlatform(true);
    frame.setVisible(true);
}

    /**
     * The main for run the GUI.
     * 
     * @param args args
     */
    public static void main(final String[] args) {
        new SimpleGUI().display();
    }
}

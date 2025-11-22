package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

/**
 * A very simple program using a graphical interface.
 *
 */
public final class SimpleGUI {
    private static final int PROPORTION = 5;
    private final JFrame frame = new JFrame();
    private final Controller controller = new SimpleController();

    /**
     * Create a new SimpleGUI.
     */
    public SimpleGUI() {
        final JPanel panel = new JPanel(new BorderLayout());
        final JPanel secondPanel = new JPanel(new BorderLayout());
        final JTextField field = new JTextField();
        final JButton printButton = new JButton("Print");
        final JButton showButton = new JButton("Show history");
        final JTextArea area = new JTextArea();
        area.setEditable(false);
        panel.add(printButton, BorderLayout.EAST);
        panel.add(showButton, BorderLayout.WEST);
        secondPanel.add(field, BorderLayout.NORTH);
        secondPanel.add(area, BorderLayout.CENTER);
        secondPanel.add(panel, BorderLayout.SOUTH);
        frame.setContentPane(secondPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent event) {
                controller.setNextString(field.getText());
                controller.printCurrentString();
            }
        });

        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent event) {
                final List<String> list = new LinkedList<>();
                for (final String s : controller.getHistory()) {
                    list.add(s);
                }
                area.setText(list.toString());
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

package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {
    private static final int PROPORTION = 5;
    private static final int APPROVE = JFileChooser.APPROVE_OPTION;
    private static final int CANCEL = JFileChooser.CANCEL_OPTION;
    private final JFrame frame = new JFrame();
    private final JFileChooser fileChooser = new JFileChooser();

    /**
     * Create a new SimpleGUIWithFileChooser.
     */
    public SimpleGUIWithFileChooser() {
        final Controller controller = new Controller();
        final JPanel panel = new JPanel(new BorderLayout());
        final JPanel secondpanel = new JPanel(new BorderLayout());
        final JTextField field = new JTextField(controller.getPath());
        final JButton button = new JButton("Browse");
        final JButton saveButton = new JButton("Save");
        final JTextArea area = new JTextArea();

        panel.add(button, BorderLayout.EAST);
        panel.add(field, BorderLayout.CENTER);
        secondpanel.add(saveButton, BorderLayout.SOUTH);
        secondpanel.add(area, BorderLayout.CENTER);
        secondpanel.add(panel, BorderLayout.NORTH);
        field.setEditable(false);
        frame.setTitle("My second GUI");
        frame.setContentPane(secondpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent event) {
                final int result = fileChooser.showSaveDialog(button);
                if (result == APPROVE) {
                    controller.setFile(fileChooser.getSelectedFile());
                    field.setText(controller.getPath());
                } else if (result != CANCEL) {
                    JOptionPane.showMessageDialog(button, "ERROR!");
                }
            }
        });

        saveButton.addActionListener(new ActionListener() {
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
        new SimpleGUIWithFileChooser().display();
    }

}

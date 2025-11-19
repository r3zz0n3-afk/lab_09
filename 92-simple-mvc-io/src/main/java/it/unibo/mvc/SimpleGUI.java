package it.unibo.mvc;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final int PROPORTION = 5;
    private final JFrame frame = new JFrame("My first application");
    private final Controller controller;

    /**
     * Create the simple interface.
     */
    public SimpleGUI() {
        controller = new Controller();
        final JPanel canvPanel = new JPanel();
        final JTextArea textArea = new JTextArea();
        final JButton buttonSave = new JButton("Save");
 
        textArea.setText("");
        canvPanel.setLayout(new BorderLayout());
        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    controller.writeToFile(textArea.getText());
                } catch (final IOException t) {
                    t.printStackTrace(); // NOPMD
                }
            }
        });

        canvPanel.add(textArea, BorderLayout.CENTER);
        canvPanel.add(buttonSave, BorderLayout.SOUTH);
        frame .setContentPane(canvPanel);
    }

    private void display() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);

        frame.setLocationByPlatform(true);

        frame.setVisible(true);

    }

    /**
     *  Launches the application.
     * 
     * @param args unused
     */
    public static void main(final String... args) {
        new SimpleGUI().display();
    }

}

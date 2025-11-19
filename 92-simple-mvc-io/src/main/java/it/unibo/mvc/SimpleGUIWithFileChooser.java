package it.unibo.mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.BorderLayout;
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
    private final JFrame frame = new JFrame("My first application");
    private final Controller controller;

    /**
     * Create the simple interface, whit File Choser.
     */
    public SimpleGUIWithFileChooser() {
        controller = new Controller();
        final JPanel canvPanel = new JPanel();
        final JPanel secondJPanel = new JPanel();
        final JTextArea textArea = new JTextArea();
        final JButton buttonSave = new JButton("Save");
        final JButton buttonBrowse = new JButton("Browse...");
        final JTextField textField = new JTextField();

        //Config the standard layout of GUI
        textArea.setText("");
        textField.setText(controller.getPathFile());
        textField.setEditable(false);
        canvPanel.setLayout(new BorderLayout());
        secondJPanel.setLayout(new BorderLayout());

        //Buttons action
        buttonSave.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    controller.writeToFile(textArea.getText());
                } catch (final IOException t) {
                    t.printStackTrace(); //NOPMD
                }
                textArea.setText("");
            }
        });
        buttonBrowse.addActionListener(new ActionListener() {

            @Override 
            public void actionPerformed(final ActionEvent e) {
                final JFileChooser fileChooser = new JFileChooser();

                final int resultSelcetion = fileChooser.showOpenDialog(frame);
                if (resultSelcetion == JFileChooser.APPROVE_OPTION) {
                    controller.setNewFile(fileChooser.getSelectedFile());
                    textField.setText(controller.getPathFile());
                } else if (resultSelcetion == JFileChooser.ERROR_OPTION) {
                    JOptionPane.showMessageDialog(frame, 
                              resultSelcetion, 
                              "Problem to select the file", 
                              JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        //Mixed the componet togheter
        secondJPanel.add(textField, BorderLayout.CENTER);
        secondJPanel.add(buttonBrowse, BorderLayout.LINE_END);
        canvPanel.add(secondJPanel, BorderLayout.NORTH);
        canvPanel.add(textArea, BorderLayout.CENTER);
        canvPanel.add(buttonSave, BorderLayout.SOUTH);
        frame.setContentPane(canvPanel);

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
        new SimpleGUIWithFileChooser().display();
    }

}

package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 *
 */
public final class SimpleGUI {

    private static final int PROPORTION = 5;
    private final JFrame frame = new JFrame("Shower history of prints");

    SimpleGUI(final Controller controller) {

        final JPanel mainJPanel = new JPanel();
        final JPanel textJPanel = new JPanel();
        final JPanel buttonsPanel = new JPanel();
        textJPanel.setLayout(new BorderLayout());
        mainJPanel.setLayout(new BorderLayout());
        buttonsPanel.setLayout(new BorderLayout());
        final JTextArea historyStrings = new JTextArea();
        final JTextField stringInput = new JTextField();
        final JButton printButton = new JButton("Print");
        final JButton showHisptryButton = new JButton("Show History");

        // Action Methods
        printButton.addActionListener(e -> { 
            controller.setNextStringToPrint(stringInput.getText());
            controller.printCurentString();
        });
        showHisptryButton.addActionListener(e -> {
            historyStrings.setText("");
            final List<String> history = controller.getHisotryPrintedString();
            history.forEach(s -> historyStrings.append(s + '\n'));
        });

        stringInput.setBackground(Color.lightGray);
        historyStrings.setEditable(false);
        textJPanel.add(historyStrings, BorderLayout.CENTER);
        textJPanel.add(stringInput, BorderLayout.NORTH);
        buttonsPanel.add(showHisptryButton, BorderLayout.LINE_START);
        buttonsPanel.add(printButton, BorderLayout.CENTER);
        mainJPanel.add(textJPanel, BorderLayout.CENTER);
        mainJPanel.add(buttonsPanel, BorderLayout.SOUTH);

        frame.setContentPane(mainJPanel);

        //Set the dimnsion of GUI
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);

        frame.setLocationByPlatform(true);

    }

    private void diplay() {
        frame.setVisible(true);
    }

    /**
     * Use for lunch the simple gui.
     * 
     * @param args  unused.
     */
    public static void main(final String... args) {
        new SimpleGUI(new SimpleController()).diplay();
    }
}

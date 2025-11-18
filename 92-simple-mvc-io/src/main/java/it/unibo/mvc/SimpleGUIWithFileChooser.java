package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

   private final JFrame frame = new JFrame("My first application");
    private static final int PROPORTION = 5;
    private Controller controller;

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
                try{
                    controller.writeToFile(textArea.getText());
                } catch (IOException t) {
                    t.printStackTrace(); //NOPMD
                }
                textArea.setText("");
            }    
        });
        buttonBrowse.addActionListener(new ActionListener() {
            
            @Override 
            public void actionPerformed(final ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();

                if(fileChooser.showOpenDialog(textField) == JFileChooser.APPROVE_OPTION) {
                    controller.setNewFile(fileChooser.getSelectedFile());
                    textField.setText(controller.getPathFile());
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
    public static void main(String... args) {
        new SimpleGUIWithFileChooser().display();
    }


}

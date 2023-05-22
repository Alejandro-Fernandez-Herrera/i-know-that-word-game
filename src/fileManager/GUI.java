package fileManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * This class is used for ...
 * @autor Carlos Felipe Montoya carlos.felipe.montoya@correounivalle.edu.co
 * @version v.1.0.0 date:21/03/2023
 */
public class GUI extends JFrame {

    private Header headerProject;
    private JTextField text;
    private JTextArea textArea;
    private FileManager fileManager;
    private Escucha escucha;

    /**
     * Constructor of GUI class
     */
    public GUI(){
        initGUI();

        //Default JFrame configuration
        this.setTitle("FileManager app");
        this.setSize(300,300);
        //this.pack();
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the GUI class
     */
    private void initGUI() {
        //Set up JFrame Container's Layout
        //Create Listener Object and Control Object
        escucha = new Escucha();
        fileManager = new FileManager();
        //Set up JComponents
        headerProject = new Header("File Manager", Color.BLACK);
        this.add(headerProject,BorderLayout.NORTH); //Change this line if you change JFrame Container's Layout

        text = new JTextField();
        text.addActionListener(escucha);
        add(text, BorderLayout.SOUTH);
        textArea = new JTextArea(10, 30);
        textArea.setText(fileManager.reader());
        JScrollPane scroll = new JScrollPane(textArea);
        this.add(scroll, BorderLayout.CENTER);
    }

    /**
     * Main process of the Java program
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            GUI miProjectGUI = new GUI();
        });
    }

    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */
    private class Escucha implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            fileManager.writer(text.getText());
            text.setText("");
            textArea.setText(fileManager.reader());
        }
    }
}

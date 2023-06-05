package I_Know_That_Word;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is used for ...
 * @autor Carlos Felipe Montoya carlos.felipe.montoya@correounivalle.edu.co
 * @version v.1.0.0 date:21/03/2023
 */
public class GUI extends JFrame {

    private Header headerProject;
    private JTextField text,name;
    private JTextArea textArea;
    private FileManager fileManager;
    private Escucha escucha;
    private Player player;
    private Model model;
    private JPanel upper,start,playerNameu,playerNamec,level,panelShowWordsU,panelShowWordsC,panelShowWordsB;
    private JButton helpButton, exitButton, play, done,continueGame,showWords;
    private ImageIcon imageStart;
    private JLabel user,showName,showActualLevel,showHits,showWord;
    private String userName = null;
    private int actualLevel = 1;

    /**
     * Constructor of GUI class
     */
    public GUI(){
        initGUI();

        //Default JFrame configuration
        this.setTitle("I KNOW THAT WORD!");
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
        this.getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        this.setUndecorated(true);
        //Create Listener Object and Control Object
        escucha = new Escucha();
        fileManager = new FileManager();
        player = new Player();
        model = new Model();
        //Set up JComponents

        //PANEL SUPERIOR
        {
            upper = new JPanel();
            upper.setBackground(Color.CYAN);
            upper.setPreferredSize(new Dimension(500, 40));
            constraints.gridx = 0;
            constraints.gridy = 0;
            constraints.gridwidth = 3;
            constraints.fill = GridBagConstraints.HORIZONTAL;
            constraints.anchor = GridBagConstraints.LINE_START;

            helpButton = new JButton("?");
            helpButton.setPreferredSize(new Dimension(65, 30));

            helpButton.addActionListener(escucha);
            upper.add(helpButton);

            headerProject = new Header("I KNOW THAT WORD!!", Color.BLACK);
            headerProject.setPreferredSize(new Dimension(350, 30));
            upper.add(headerProject);

            exitButton = new JButton("Salir");
            exitButton.setPreferredSize(new Dimension(65, 30));
            exitButton.addActionListener(escucha);
            upper.add(exitButton);

            this.add(upper, constraints);
        }
        //PANEL INICIO
        {
            start = new JPanel();
            start.setBackground(Color.CYAN);
            start.setPreferredSize(new Dimension(500, 360));
            constraints.gridx = 0;
            constraints.gridy = 1;
            constraints.gridwidth = 3;
            constraints.fill = GridBagConstraints.BOTH;
            constraints.anchor = GridBagConstraints.LINE_START;
            imageStart = new ImageIcon(this.getClass().getResource("/myProject/archivos/imagenInicio.png"));
            JLabel picLabel = new JLabel(imageStart);
            start.add(picLabel);

            play = new JButton("Jugar");
            play.addActionListener(escucha);
            start.add(play);

            this.add(start, constraints);
        }
        //PANEL NOMBRE USUARIO

        {
            playerNameu = new JPanel();
            playerNameu.setBackground(Color.CYAN);
            playerNameu.setPreferredSize(new Dimension(500, 120));
            constraints.gridx = 0;
            constraints.gridy = 2;
            constraints.gridwidth = 4;
            constraints.anchor = GridBagConstraints.PAGE_START;

            this.add(playerNameu, constraints);

            playerNameu = new JPanel();
            playerNameu.setBackground(Color.CYAN);
            playerNameu.setPreferredSize(new Dimension(500, 120));
            constraints.gridx = 0;
            constraints.gridy = 3;
            constraints.gridwidth = 4;
            constraints.anchor = GridBagConstraints.CENTER;

            this.add(playerNameu, constraints);

            user = new JLabel("Enter your name");

            name = new JTextField(30);

            playerNameu.add(user);
            playerNameu.add(name);

            playerNamec = new JPanel();
            playerNamec.setBackground(Color.CYAN);
            playerNamec.setPreferredSize(new Dimension(500, 120));
            constraints.gridx = 0;
            constraints.gridy = 4;
            constraints.gridwidth = 4;
            constraints.anchor = GridBagConstraints.PAGE_END;

            this.add(playerNamec, constraints);

            done = new JButton("Done");
            done.addActionListener(escucha);

            playerNamec.add(done);

            //PANEL MOSTRAR ESTADO
            {
                level = new JPanel();
                level.setBackground(Color.CYAN);
                level.setPreferredSize(new Dimension(500, 30));
                constraints.gridx = 0;
                constraints.gridy = 1;
                constraints.gridwidth = 3;

                showName = new JLabel("User: " + userName);
                showName.setSize(new Dimension(100, 30));
                showName.setFont(new Font(Font.DIALOG, Font.BOLD, 20));

                showActualLevel = new JLabel(" Actual level: " + actualLevel);
                showActualLevel.setSize(new Dimension(100, 30));
                showActualLevel.setFont(new Font(Font.DIALOG, Font.BOLD, 20));

                showHits = new JLabel("Hits: " + model.aciertos);
                showHits.setSize(new Dimension(100, 30));
                showHits.setFont(new Font(Font.DIALOG, Font.BOLD, 20));

                //estadoActual.add(ayuda);
                level.add(showName);
                level.add(showActualLevel);
                level.add(showHits);
                //estadoActual.add(salir);

                this.add(level, constraints);
            }
            //PANEL MOSTRAR PALABRAS
            {
                panelShowWordsU = new JPanel();
                panelShowWordsU.setBackground(Color.CYAN);
                panelShowWordsU.setPreferredSize(new Dimension(500, 80));
                constraints.gridx = 0;
                constraints.gridy = 2;
                constraints.gridwidth = 3;

                this.add(panelShowWordsU, constraints);

                panelShowWordsC = new JPanel();
                panelShowWordsC.setBackground(Color.ORANGE);
                panelShowWordsC.setPreferredSize(new Dimension(500, 150));
                constraints.gridx = 0;
                constraints.gridy = 3;
                constraints.gridwidth = 3;

                this.add(panelShowWordsC, constraints);

                showWord = new JLabel("                                                     ");
                showWord.setSize(500, 150);
                showWord.setFont(new Font(Font.DIALOG, Font.BOLD, 30));
                showWord.setSize(500, 500);
                panelShowWordsC.add(showWord);

                showWord = new JLabel("Aquí se mostrarán las palabras");
                showWord.setSize(500, 150);
                showWord.setFont(new Font(Font.DIALOG, Font.BOLD, 30));
                showWord.setSize(500, 500);
                panelShowWordsC.add(showWord);

                panelShowWordsB = new JPanel();
                panelShowWordsB.setBackground(Color.CYAN);
                panelShowWordsB.setPreferredSize(new Dimension(500, 100));
                constraints.gridx = 0;
                constraints.gridy = 4;
                constraints.gridwidth = 3;

                this.add(panelShowWordsB, constraints);

                continueGame = new JButton("Continue");
                continueGame.addActionListener(escucha);
                continueGame.setEnabled(false);

                panelShowWordsB.add(continueGame);

                showWords = new JButton("Start");
                showWords.addActionListener(escucha);

                panelShowWordsB.add(showWords);

            }
        }
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
            GUI GUI = new GUI();
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

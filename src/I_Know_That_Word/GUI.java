package I_Know_That_Word;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.util.ArrayList;

/**
 * This class is used for ...
 * @autor Carlos Felipe Montoya carlos.felipe.montoya@correounivalle.edu.co
 * @version v.1.0.0 date:21/03/2023
 */
public class GUI extends JFrame {

    private Header headerProject;
    private JTextField name;

    private FileManager fileManager;
    private Escucha escucha;
    private Player player;
    private Model model;
    private JPanel resultScreenIn,upper,start,playerNameu,playerNameC,playerNameB,level,panelShowWordsU,resultScreenCe,panelShowWordsC,panelShowWordsB,selectWordsU,resultScreenSu,selectWordsC,selectWordsB;
    private JButton helpButton, exitButton, play, done,continueGame,showWords,yesButton,noButton,restartLevelButton,nextLevelButton;
    private ImageIcon imageStart;
    private JLabel user,showName,showActualLevel,showHits,showWord,selectWords,statisticsLabel;
    private String userName = null;
    private int actualLevel = 1;
    private JTextPane resultTextPane;
    private Timer showTimer,selectTimer;
    private int maximumLevelPassed = 0;
    private String word;
    private ArrayList<String> palabrasLevel, palabrasVistas;
    private int successPercentage = 0;
    private Object args;

    /**
     * Constructor of GUI class
     */
    public GUI()
    {
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
    private void initGUI()
    {
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
            imageStart = new ImageIcon(this.getClass().getResource(""));
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

            playerNameC = new JPanel();
            playerNameC.setBackground(Color.CYAN);
            playerNameC.setPreferredSize(new Dimension(500, 120));
            constraints.gridx = 0;
            constraints.gridy = 3;
            constraints.gridwidth = 4;
            constraints.anchor = GridBagConstraints.CENTER;

            this.add(playerNameC, constraints);

            user = new JLabel("Enter your name");

            name = new JTextField(30);

            playerNameC.add(user);
            playerNameC.add(name);

            playerNameB = new JPanel();
            playerNameB.setBackground(Color.CYAN);
            playerNameB.setPreferredSize(new Dimension(500, 120));
            constraints.gridx = 0;
            constraints.gridy = 4;
            constraints.gridwidth = 4;
            constraints.anchor = GridBagConstraints.PAGE_END;

            this.add(playerNameB, constraints);

            done = new JButton("Done");
            done.addActionListener(escucha);

            playerNameB.add(done);
        }

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
            //PANEL SELECCIONAR PALABRAS
        {
            selectWordsU = new JPanel();
            selectWordsU.setBackground(Color.CYAN);
            selectWordsU.setPreferredSize(new Dimension(500, 110));
            constraints.gridx = 0;
            constraints.gridy = 2;
            constraints.gridwidth = 3;

            this.add(selectWordsU, constraints);

            selectWordsC = new JPanel();
            selectWordsC.setBackground(Color.CYAN);
            selectWordsC.setPreferredSize(new Dimension(500, 110));
            constraints.gridx = 0;
            constraints.gridy = 3;
            constraints.gridwidth = 3;

            this.add(selectWordsC, constraints);

            selectWords = new JLabel("¡Buena suerte!");
            selectWords.setFont(new Font(Font.DIALOG, Font.BOLD, 30));

            selectWordsC.add(selectWords);

            selectWordsB = new JPanel();
            selectWordsB.setBackground(Color.CYAN);
            selectWordsB.setPreferredSize(new Dimension(500, 110));
            constraints.gridx = 0;
            constraints.gridy = 4;
            constraints.gridwidth = 3;

            this.add(selectWordsB, constraints);

            yesButton = new JButton("Sí");
            yesButton.setEnabled(false);
            yesButton.setPreferredSize(new Dimension(100, 30));
            yesButton.addActionListener(escucha);

            noButton = new JButton("No");
            noButton.setEnabled(false);
            noButton.setPreferredSize(new Dimension(100, 30));
            noButton.addActionListener(escucha);

            selectWordsB.add(yesButton);
            selectWordsB.add(noButton);

        }

            //PANEL RESULTADOS
        {
            resultScreenSu = new JPanel();
            resultScreenSu.setBackground(Color.CYAN);
            resultScreenSu.setPreferredSize(new Dimension(500, 200));
            constraints.gridx = 0;
            constraints.gridy = 2;
            constraints.gridwidth = 3;

            this.add(resultScreenSu, constraints);

            resultScreenCe = new JPanel();
            resultScreenCe.setBackground(Color.CYAN);
            resultScreenCe.setPreferredSize(new Dimension(500, 65));
            constraints.gridx = 0;
            constraints.gridy = 3;
            constraints.gridwidth = 3;

            this.add(resultScreenCe, constraints);


            resultScreenIn = new JPanel();
            resultScreenIn.setAlignmentX(Component.CENTER_ALIGNMENT);
            resultScreenIn.setBackground(Color.CYAN);
            resultScreenIn.setPreferredSize(new Dimension(500, 65));
            constraints.gridx = 0;
            constraints.gridy = 4;
            constraints.gridwidth = 3;

            this.add(resultScreenIn, constraints);

            statisticsLabel = new JLabel("Your statistics will be displayed here");
            statisticsLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 20));

            resultTextPane = new JTextPane();
            resultTextPane.setText("Your result will be displayed here");
            resultTextPane.setPreferredSize(new Dimension(400, 200));

            StyledDocument doc = resultTextPane.getStyledDocument();
            SimpleAttributeSet center = new SimpleAttributeSet();
            StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
            doc.setParagraphAttributes(0, doc.getLength(), center, false);


            resultTextPane.setEditable(false);
            resultTextPane.setOpaque(false);
            resultTextPane.setFont(new Font(Font.DIALOG, Font.BOLD, 30));

            restartLevelButton = new JButton("Restart Level");
            restartLevelButton.addActionListener(escucha);
            restartLevelButton.setPreferredSize(new Dimension(100, 30));
            restartLevelButton.setVisible(false);

            nextLevelButton = new JButton("Next Level");
            nextLevelButton.addActionListener(escucha);
            nextLevelButton.setVisible(false);

            resultScreenSu.add(statisticsLabel);
            resultScreenSu.add(resultTextPane);
            resultScreenCe.add(nextLevelButton);
            resultScreenCe.add(restartLevelButton);

        }

        upper.setVisible(true);
        start.setVisible(true);
        level.setVisible(false);
        playerNameu.setVisible(false);
        playerNameC.setVisible(false);
        playerNameB.setVisible(false);
        panelShowWordsU.setVisible(false);
        panelShowWordsC.setVisible(false);
        panelShowWordsB.setVisible(false);
        selectWordsU.setVisible(false);
        selectWordsC.setVisible(false);
        selectWordsB.setVisible(false);
        resultScreenSu.setVisible(false);
        resultScreenCe.setVisible(false);
        resultScreenIn.setVisible(false);

        showTimer = new Timer(5000, escucha);
        selectTimer = new Timer(7000, escucha);

        }

        /**
         * Dependiendo del porcentaje de aciertos, lanza el mensaje de resultados
         */

        public void resultados()
        {
            if (model.LevelSucess())
            {
                if (actualLevel == 10)
                {
                    resultTextPane.setText("You have reached the maximum level, you can repeat it if you wish.");
                    statisticsLabel.setText("Accuracy percentage: " + model.porcentaje + "%");
                    restartLevelButton.setVisible(true);
                    maximumLevelPassed = actualLevel;
                }
                else
                {
                    resultTextPane.setText("You have passed this level, you can proceed to the next level.");
                    statisticsLabel.setText("Accuracy percentage: " + model.porcentaje + "%");
                    nextLevelButton.setVisible(true);
                    maximumLevelPassed = actualLevel;
                    actualLevel = actualLevel + 1;
                }
            }
            else
            {
                resultTextPane.setText("You have failed this level, you cannot proceed to the next level.");
                restartLevelButton.setVisible(true);
            }
        }


        public static void main(String[] args)
        {
            EventQueue.invokeLater(() ->
            {
                GUI gui = new GUI();
            });
        }

        /**
         * inner class that extends an Adapter Class or implements Listeners used by GUI class
         */
        private class Escucha implements ActionListener
        {
            private int counter;

            public Escucha()
            {
                counter = 0;
            }

            @Override
            public void actionPerformed(ActionEvent e)
            {

                if (e.getSource() == helpButton)
                {
                    JOptionPane.showMessageDialog(null, "Este juego consiste en recordar las palabras mostradas y determinar si están en la siguiente aparición");
                }

                if (e.getSource() == exitButton)
                {
                    if (player.isNameEmpty(userName) == true)
                    {
                        System.exit(0);
                    }
                    else
                    {
                        if (player.isRegistered(userName) == true)
                        {
                            player.updateUser(userName, maximumLevelPassed);
                        } else
                        {
                            player.registerPlayer(userName, maximumLevelPassed);
                        }
                        System.exit(0);
                    }
                }

                if (e.getSource() == play)
                {
                    start.setVisible(false);
                    playerNameu.setVisible(true);
                    playerNameB.setVisible(true);
                    playerNameB.setVisible(true);
                }

                if (e.getSource() == done)
                {

                    System.out.println(actualLevel);

                    userName = name.getText().replaceAll("\\s+", "");

                    if (player.isNameEmpty(userName) == false)
                    {
                        if (player.isRegistered(userName) == true)
                        {
                            maximumLevelPassed = player.getLevel();

                            if (maximumLevelPassed < 0 || maximumLevelPassed > 10)
                            {
                                JOptionPane.showMessageDialog(null, "Error de sistema.");
                                System.exit(0);
                            }

                            if (maximumLevelPassed == 10)
                            {
                                actualLevel = 10;
                            }
                            else
                            {
                                actualLevel = maximumLevelPassed + 1;
                            }
                            JOptionPane.showMessageDialog(null, "Usted ya se encuentra registrado, su nivel máximo superado es: " + maximumLevelPassed);
                        }
                        else
                        {
                            actualLevel = 1;
                            maximumLevelPassed = 0;
                        }

                        showName.setText("Usuario: " + userName);
                        showActualLevel.setText("Nivel actual: " + actualLevel);
                        showHits.setText("Aciertos: " + model.aciertos);

                        playerNameu.setVisible(false);
                        playerNameC.setVisible(false);
                        playerNameB.setVisible(false);

                        level.setVisible(true);
                        panelShowWordsU.setVisible(true);
                        panelShowWordsC.setVisible(true);
                        panelShowWordsB.setVisible(true);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "El nombre es muy corto o está vacío");
                    }
                }

                if (e.getSource() == showWords)
                {
                    selectWords.setEnabled(false);
                    model.nivelPalabras(actualLevel);
                    palabrasLevel = model.getArrayPalabrasLevel();
                    palabrasVistas = model.getArrayPalabrasMemorizar();
                    System.out.println(palabrasLevel + "" + palabrasLevel.toArray().length);
                    System.out.println(palabrasVistas + "" + palabrasVistas.toArray().length);
                    counter = 0;
                    showTimer.start();
                }

                if (e.getSource() == continueGame)
                {
                    panelShowWordsU.setVisible(false);
                    panelShowWordsC.setVisible(false);
                    panelShowWordsB.setVisible(false);
                    selectWordsU.setVisible(true);
                    selectWordsC.setVisible(true);
                    selectWordsB.setVisible(true);
                    counter = 0;
                    selectTimer.start();
                }

                if (e.getSource() == yesButton)
                {
                    yesButton.setEnabled(false);
                    noButton.setEnabled(false);
                    if (model.palabraEstaEnNivel(word) == true)
                    {
                        model.aciertos = model.aciertos + 1;
                    }
                    showHits.setText("Aciertos: " + model.aciertos);
                }

                if (e.getSource() == noButton)
                {
                    noButton.setEnabled(false);
                    yesButton.setEnabled(false);
                    if (model.palabraEstaEnNivel(word) == false)
                    {
                        model.aciertos = model.aciertos + 1;
                    }
                    showHits.setText("Aciertos: " + model.aciertos);
                }

                if (e.getSource() == nextLevelButton)
                {
                    resultScreenSu.setVisible(false);
                    resultScreenCe.setVisible(false);
                    resultScreenIn.setVisible(false);
                    panelShowWordsU.setVisible(true);
                    panelShowWordsC.setVisible(true);
                    panelShowWordsB.setVisible(true);
                    showWord.setText("Aquí se mostrarán las palabras");
                    showWords.setEnabled(true);
                    continueGame.setEnabled(false);
                    model.aciertos = 0;
                    showHits.setText("Aciertos: " + model.aciertos);
                    showActualLevel.setText("Nivel actual: " + actualLevel);
                    model.arrayPalabrasLevel.clear();
                    model.arrayPalabrasVistas.clear();
                }

                if (e.getSource() == restartLevelButton)
                {
                    resultScreenSu.setVisible(false);
                    resultScreenCe.setVisible(false);
                    resultScreenIn.setVisible(false);
                    panelShowWordsU.setVisible(true);
                    panelShowWordsC.setVisible(true);
                    panelShowWordsB.setVisible(true);
                    showWord.setText("Aquí se mostrarán las palabras");
                    showWords.setEnabled(true);
                    continueGame.setEnabled(false);
                    model.aciertos = 0;
                    showHits.setText("Aciertos: " + model.aciertos);
                    showActualLevel.setText("Nivel actual: " + actualLevel);
                    model.arrayPalabrasLevel.clear();
                    model.arrayPalabrasVistas.clear();
                }

                if (e.getSource() == showTimer)
                {

                    if (counter < model.palabrasVistas)
                    {
                        showWord.setText(palabrasVistas.get(counter));
                        counter++;
                    }
                    else
                    {
                        showTimer.stop();
                        showWord.setText("¡Buena suerte!");
                        continueGame.setEnabled(true);
                        counter = 0;
                        model.estado = 1;
                    }
                }

                if (e.getSource() == selectTimer)
                {
                    yesButton.setEnabled(true);
                    noButton.setEnabled(true);
                    if (counter < model.palabrasLevel)
                    {
                        selectWords.setText(palabrasLevel.get(counter));
                        word = palabrasLevel.get(counter);
                        System.out.println(model.palabraEstaEnNivel(word));
                        counter++;
                    }
                    else
                    {
                        selectTimer.stop();
                        nextLevelButton.setVisible(false);
                        restartLevelButton.setVisible(false);
                        successPercentage = model.calcularPorcentaje();
                        model.estado = 0;
                        counter = 0;
                        selectWordsU.setVisible(false);
                        selectWordsC.setVisible(false);
                        selectWordsB.setVisible(false);
                        resultScreenSu.setVisible(true);
                        resultScreenCe.setVisible(true);
                        resultScreenIn.setVisible(true);
                        resultados();
                    }

                }

                revalidate();
                repaint();
            }
        }
    }




package view;

import javax.swing.JPanel;
import model.TTT;


import controller.GamePlayListener;
import model.TTT;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JPanel;



import java.awt.Container;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;



public class GameBoardModel {

    public enum GameState {
        PLAYER1, PLAYER2, AI, CHOOSE
    }

    private model.TTT ttt;

    private JFrame window;
    private JButton[] gameButtons;
    private JButton quitButton = new JButton("Quit");
    private JButton hVsAiButton = new JButton("Human vs AI");
    private JButton aIvSaIButton = new JButton("AI vs AI");
    private GameState gameState = GameState.CHOOSE;
    private Icon emptySquare = new ImageIcon("images/resizeEmpty.png");
    private Icon xIcon = new ImageIcon("images/xIcon.png");
    private JRadioButton p1Button = new JRadioButton("Play First");
    private JRadioButton p2Button = new JRadioButton("Play Second");
    private JRadioButton xButton = new JRadioButton("X");
    private JRadioButton oButton = new JRadioButton("O");


    public GameBoardModel(JFrame window){
        this.window = window;
    }


    public void init(){

        Container cp = window.getContentPane();
        GamePlayListener buttonListener = new GamePlayListener(this);
        

        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(5, 5));

        gameButtons = new JButton[25];

        for (int j = 0; j < 25; j++){
            //gameButtons[j] = new JButton(emptySquare);
            gameButtons[j] = new JButton();
            boardPanel.add(gameButtons[j]);
            gameButtons[j].setFont(new Font("Serif", Font.BOLD, 50));
            gameButtons[j].addActionListener(buttonListener);
        }

        for (var b: gameButtons){
            b.setEnabled(false);
            b.setText("[]");
        }

        

        cp.add(BorderLayout.CENTER, boardPanel);
        

        JPanel southPanel = new JPanel();
        //southPanel.setLayout(new FlowLayout());
        southPanel.setLayout(new GridLayout(3,1));
        cp.add(BorderLayout.SOUTH, southPanel);

        JPanel south1 = new JPanel();
        south1.setLayout(new FlowLayout());
        

        //south1.add(quitButton);
        south1.add(hVsAiButton);
        south1.add(aIvSaIButton);
        //quitButton.setEnabled(false);
        hVsAiButton.setEnabled(true);
        aIvSaIButton.setEnabled(true);
        //quitButton.addActionListener(buttonListener);
        hVsAiButton.addActionListener(buttonListener);
        aIvSaIButton.addActionListener(buttonListener);
        southPanel.add(south1);

        JPanel south2 = new JPanel();
        south2.setLayout(new FlowLayout());
        ButtonGroup playerGroup = new ButtonGroup();
        south2.add(p1Button);
        south2.add(p2Button);
        playerGroup.add(p1Button);
        playerGroup.add(p2Button);
        southPanel.add(south2);

        JPanel south3 = new JPanel();
        south3.setLayout(new FlowLayout());
        ButtonGroup choiceGroup = new ButtonGroup();
        south3.add(xButton);
        south3.add(oButton);
        choiceGroup.add(xButton);
        choiceGroup.add(oButton);
        southPanel.add(south3);
        


        
    } // end of init

    public GameState getGameState(){
        return gameState;
    }

    public void setGameState(GameState state){
        this.gameState = state;
    }

    public JButton getQuitButton() {
        return quitButton;
    }

    public JButton getaIvSaIButton() {
        return aIvSaIButton;
    }

    public JButton gethVsAiButton() {
        return hVsAiButton;
    }

    public JButton[] getGameButtons() {
        return gameButtons;
    }

    public JRadioButton getP1Button() {
        return p1Button;
    }

    public JRadioButton getP2Button() {
        return p2Button;
    }

    public JRadioButton getxButton() {
        return xButton;
    }

    public JRadioButton getoButton() {
        return oButton;
    }

    public Icon getxIcon() {
        return xIcon;
    }

    public TTT getTTT() {
        return ttt;
    }

    public void setTTT(TTT ttt) {
        this.ttt = ttt;
    }

    
}

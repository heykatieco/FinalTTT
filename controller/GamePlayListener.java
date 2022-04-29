package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;

import javax.swing.JButton;

import model.TTT;
import model.TTT.Player;
import view.GameBoardModel;




public class GamePlayListener implements ActionListener {

    private GameBoardModel model;
    //private GameSpace[] gameSpaces;
    //private TTT ttt;

    public GamePlayListener(GameBoardModel model){
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        JButton button = (JButton) e.getSource();


        if (button == model.gethVsAiButton()){

            var ttt = new TTT();

            ttt.playGame();
            if (model.getxButton().isSelected() == true) {
                ttt.setPlayer(TTT.Player.Human);
                ttt.getPlayer().setAssignment("x");
                ttt.setPlayer(TTT.Player.AI);
                ttt.getPlayer().setAssignment("o");
            } else {
                ttt.setPlayer(TTT.Player.Human);
                ttt.getPlayer().setAssignment("o");
                ttt.setPlayer(TTT.Player.AI);
                ttt.getPlayer().setAssignment("x");
            }

            model.getQuitButton().setEnabled(true);
            model.getaIvSaIButton().setEnabled(false);
            model.gethVsAiButton().setEnabled(false);
            model.getxButton().setEnabled(false);
            model.getoButton().setEnabled(false);
            model.getP1Button().setEnabled(false);
            model.getP2Button().setEnabled(false);

            for (var b:model.getGameButtons()){
                b.setEnabled(true);
            }

            if (model.getP1Button().isSelected() == false) {
                ttt.AI_Selection();
                model.setTTT(ttt);
                model.getGameButtons()[ttt.getAI_Choice()].doClick();
                ttt.setPlayer(TTT.Player.Human);
            } else {
                ttt.setPlayer(TTT.Player.Human);
                model.setTTT(ttt);
            }

            model.setTTT(ttt);
            
        } else if (button == model.getaIvSaIButton()){

            var ttt = new TTT();

            ttt.playGame();
            if (model.getP1Button().isSelected() == true) {
                if (model.getxButton().isSelected() == true) {
                    ttt.setPlayer(TTT.Player.Human);
                    ttt.getPlayer().setAssignment("x");
                } else {
                    ttt.setPlayer(TTT.Player.Human);
                    ttt.getPlayer().setAssignment("o");
                }
            } else {
                if (model.getxButton().isSelected() == true) {
                    ttt.setPlayer(TTT.Player.AI);
                    ttt.getPlayer().setAssignment("x");
                } else {
                    ttt.setPlayer(TTT.Player.AI);
                    ttt.getPlayer().setAssignment("o");
                }
            }

            model.getQuitButton().setEnabled(true);
            model.getaIvSaIButton().setEnabled(false);
            model.gethVsAiButton().setEnabled(false);
            model.getxButton().setEnabled(false);
            model.getoButton().setEnabled(false);
            model.getP1Button().setEnabled(false);
            model.getP2Button().setEnabled(false);

            for (var b:model.getGameButtons()){
                b.setEnabled(true);
            }

            if (model.getP1Button().isEnabled() == false) {
                try {
                    ServerSocket server = new ServerSocket(6666);
                    Socket s = server.accept();
                    
                    DataInputStream input = new DataInputStream(s.getInputStream());
                    
                    DataOutputStream output = new DataOutputStream(s.getOutputStream());  
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                    
                    String text="", text2="";  
                    while(!text.equals("stop")){  
                    text=input.readUTF();  
                    System.out.println("From Client: "+ text);  
                    text2=reader.readLine();  
                    output.writeUTF(text2);  
                    output.flush(); 
                    }
            
                    input.close();  
                    s.close();  
                    server.close();
                    }catch(Exception c){System.out.println(c);}
            } else {
                try{	
                    Socket client =new Socket("localhost",6666);
                    
                    DataInputStream input = new DataInputStream(client.getInputStream());	
                    DataOutputStream output = new DataOutputStream(client.getOutputStream());
                    
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                    
                    String text = "",text2 = "";  
                    while(!text.equals("stop")){  
                    text=reader.readLine();  
                    output.writeUTF(text);  
                    output.flush();  
                    text2=input.readUTF();  
                    System.out.println("From Server: " + text2);  
                    }  
                      
                    output.close();  
                    client.close();
                    
                    }catch(Exception c){System.out.println(c);}
            }

        } else {

            String playerChoice;

            for (int k=0; k < 25; k++){

                if (button == model.getGameButtons()[k]){

                    playerChoice = model.getTTT().getPlayer().getAssignment();
                    model.getGameButtons()[k].setEnabled(false);
                    model.getGameButtons()[k].setText(playerChoice);
                    model.getTTT().setInput(model.getTTT().getPlayer(), k);
                    model.getTTT().checkWinner(model.getTTT().getPlayer());

                    break;
                }
            }

            if (model.getTTT().getWinner() == true) {
                for (int i = 0; i < 25; i++) {
                    if (model.getGameButtons()[i].isEnabled() == true) {
                        model.getGameButtons()[i].setEnabled(false);
                    }
                }
                System.out.println(model.getTTT().getPlayer().getAssignment() + " Wins!");
            }


            if(model.getTTT().getPlayer() == TTT.Player.AI) {
                model.getTTT().setPlayer(TTT.Player.Human);
            } else {
                model.getTTT().AI_Selection();
                model.getTTT().setPlayer(TTT.Player.AI);
                model.getGameButtons()[model.getTTT().getAI_Choice()].doClick();
            }
            
        } 
    }    
}

import view.GameBoardModel;

import javax.swing.JFrame;

class Main {


    public static void main(String[] args){

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Tic-Tac-Toe");
        window.setLocation(200,100);

        var game = new GameBoardModel(window);
        game.init();

        window.setResizable(false);
        window.pack();
        window.setVisible(true);
      

    }
}

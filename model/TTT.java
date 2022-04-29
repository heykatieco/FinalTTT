package model;

import java.util.Enumeration;
import java.util.Random;
import java.util.Vector;

public class TTT {

    private static Vector<String> X_Storage = new Vector<String>();
    private static Vector<String> O_Storage = new Vector<String>();
    private static Vector<Integer> Chosen = new Vector<Integer>();
    private int inputs;
    private int AI_Choice;
    Random random = new Random();
    private static boolean winner = false;

    public enum Player {
        Choose, Human, AI, AI2, Draw;
        public String assignment;
        public void setAssignment(String x) {
            assignment = x;
        }
        public String getAssignment() {
            return assignment;
        }
    }
    private Player player;

    public void playGame() {
        for (int i = 0; i < 25; i++) {
            X_Storage.add(null);
        }
        for (int i = 0; i < 25; i++) {
            O_Storage.add(null);
        }
        player.Human.assignment = null;
        player.AI.assignment = null;
        player.AI2.assignment = null;
        inputs = 0;
    }

    public void setInput(Player player, int x) {
        if (player == Player.Human  && player.Human.assignment == "x") {
            getX_Storage().set(x, "x");
        } else if (player == Player.Human && player.Human.assignment == "o") {
            getO_Storage().set(x, "o");
        } else if (player == Player.AI && player.AI.assignment == "x") {
            getX_Storage().set(AI_Selection(), "x");
        } else if (player == Player.AI && player.AI.assignment == "o") {
            getO_Storage().set(AI_Selection(), "o");
        } else if (player == Player.AI2 && player.AI2.assignment == "x") {
            getX_Storage().set(AI_Selection(), "x");
        } else if (player == Player.AI2 && player.AI2.assignment == "o") {
            getO_Storage().set(AI_Selection(), "o");
        }
        Chosen.add(x);
        inputs++;
    }

    public int AI_Selection() {
        AI_Choice = random.nextInt(25);
        if (Chosen.isEmpty() == false) {
            while (Chosen.contains(AI_Choice) == true) {
                AI_Choice = random.nextInt(25);
            }
        }
        Chosen.add(AI_Choice);
        inputs++;
        return AI_Choice;
    }

    public void checkWinner(Player player) {
        String line = null;

        if (player.assignment == "x") {
            for (int a = 0; a < 12; a++) {
                switch(a) {
                    case 0:
                        line = getX_Storage().get(0) + getX_Storage().get(1) + getX_Storage().get(2) + getX_Storage().get(3) + getX_Storage().get(4);
                        break;
                    case 1:
                        line = getX_Storage().get(5) + getX_Storage().get(6) + getX_Storage().get(7) + getX_Storage().get(8) + getX_Storage().get(9);
                        break;
                    case 2:
                        line = getX_Storage().get(10) + getX_Storage().get(11) + getX_Storage().get(12) + getX_Storage().get(13) + getX_Storage().get(14);
                        break;
                    case 3:
                        line = getX_Storage().get(15) + getX_Storage().get(16) + getX_Storage().get(17) + getX_Storage().get(18) + getX_Storage().get(19);
                        break;
                    case 4:
                        line = getX_Storage().get(20) + getX_Storage().get(21) + getX_Storage().get(22) + getX_Storage().get(23) + getX_Storage().get(24);
                        break;
                    case 5:
                        line = getX_Storage().get(0) + getX_Storage().get(5) + getX_Storage().get(10) + getX_Storage().get(15) + getX_Storage().get(20);
                        break;
                    case 6:
                        line = getX_Storage().get(1) + getX_Storage().get(6) + getX_Storage().get(11) + getX_Storage().get(16) + getX_Storage().get(21);
                        break;
                    case 7:
                        line = getX_Storage().get(2) + getX_Storage().get(7) + getX_Storage().get(12) + getX_Storage().get(17) + getX_Storage().get(22);
                        break;
                    case 8:
                        line = getX_Storage().get(3) + getX_Storage().get(8) + getX_Storage().get(13) + getX_Storage().get(18) + getX_Storage().get(23);
                        break;
                    case 9:
                        line = getX_Storage().get(4) + getX_Storage().get(9) + getX_Storage().get(14) + getX_Storage().get(19) + getX_Storage().get(24);
                        break;
                    case 10:
                        line = getX_Storage().get(0) + getX_Storage().get(6) + getX_Storage().get(12) + getX_Storage().get(18) + getX_Storage().get(24);
                        break;
                    case 11:
                        line = getX_Storage().get(4) + getX_Storage().get(8) + getX_Storage().get(12) + getX_Storage().get(16) + getX_Storage().get(20);
                        break;
                }

                if (line.equals("xxxxx")) {
                    setWinner_TRUE();
                }
            }
        } else if (player.assignment == "o") {
            for (int a = 0; a < 12; a++) {
                switch(a) {
                    case 0:
                        line = getO_Storage().get(0) + getO_Storage().get(1) + getO_Storage().get(2) + getO_Storage().get(3) + getO_Storage().get(4);
                        break;
                    case 1:
                        line = getO_Storage().get(5) + getO_Storage().get(6) + getO_Storage().get(7) + getO_Storage().get(8) + getO_Storage().get(9);
                        break;
                    case 2:
                        line = getO_Storage().get(10) + getO_Storage().get(11) + getO_Storage().get(12) + getO_Storage().get(13) + getO_Storage().get(14);
                        break;
                    case 3:
                        line = getO_Storage().get(15) + getO_Storage().get(16) + getO_Storage().get(17) + getO_Storage().get(18) + getO_Storage().get(19);
                        break;
                    case 4:
                        line = getO_Storage().get(20) + getO_Storage().get(21) + getO_Storage().get(22) + getO_Storage().get(23) + getO_Storage().get(24);
                        break;
                    case 5:
                        line = getO_Storage().get(0) + getO_Storage().get(5) + getO_Storage().get(10) + getO_Storage().get(15) + getO_Storage().get(20);
                        break;
                    case 6:
                        line = getO_Storage().get(1) + getO_Storage().get(6) + getO_Storage().get(11) + getO_Storage().get(16) + getO_Storage().get(21);
                        break;
                    case 7:
                        line = getO_Storage().get(2) + getO_Storage().get(7) + getO_Storage().get(12) + getO_Storage().get(17) + getO_Storage().get(22);
                        break;
                    case 8:
                        line = getO_Storage().get(3) + getO_Storage().get(8) + getO_Storage().get(13) + getO_Storage().get(18) + getO_Storage().get(23);
                        break;
                    case 9:
                        line = getO_Storage().get(4) + getO_Storage().get(9) + getO_Storage().get(14) + getO_Storage().get(19) + getO_Storage().get(24);
                        break;
                    case 10:
                        line = getO_Storage().get(0) + getO_Storage().get(6) + getO_Storage().get(12) + getO_Storage().get(18) + getO_Storage().get(24);
                        break;
                    case 11:
                        line = getO_Storage().get(4) + getO_Storage().get(8) + getO_Storage().get(12) + getO_Storage().get(16) + getO_Storage().get(20);
                        break;
                }

                if (line.equals("ooooo")) {
                    setWinner_TRUE();
                }
            }
        }


    }


    public int getAI_Choice() {
        return AI_Choice;
    }

    public void setPlayer(Player p) {
        this.player = p;
    }
    
    public Player getPlayer() {
        return player;
    }

    public static Vector<String> getO_Storage() {
        return O_Storage;
    }

    public static Vector<String> getX_Storage() {
        return X_Storage;
    }

    public static void setWinner_TRUE() {
        winner = true;
    }

    public boolean getWinner() {
        return winner;
    }

    public int getInputs() {
        return inputs;
    }

}

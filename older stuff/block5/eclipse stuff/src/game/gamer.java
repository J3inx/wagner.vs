package game;

import java.util.Random;
import javax.swing.*;

public class gamer {
    public static void main(String[] args) {
        String play = JOptionPane.showInputDialog("Automatic or manual gamemode?");
        if (play.equalsIgnoreCase("automatic")) {
            // Automatic mode logic here (not implemented)
        } else if (play.equalsIgnoreCase("manual")) {
            int[] envelopes = {0, 0, 0};
            Random rand = new Random();
            int prizeIndex = rand.nextInt(3);
            envelopes[prizeIndex] = 1;

            String[] players = {"A", "B", "C"};
            int playerChoiceIndex = setUpPlayers(players);

            System.out.println("Envelope setup: " + envelopes[0] + " " + envelopes[1] + " " + envelopes[2]);
            int revealedIndex = eliminatePlayers(envelopes, players, prizeIndex, playerChoiceIndex);
            if (revealedIndex == -1) return;
            boolean win = switchDoors(envelopes, playerChoiceIndex, revealedIndex, prizeIndex);
            JOptionPane.showMessageDialog(null, win ? "Congratulations! You won!" : "Sorry, you lost.");
        } else {
            JOptionPane.showMessageDialog(null, "Invalid game mode selected.");
        }
        System.exit(0);
    }

    public static int setUpPlayers(String[] players) {
        String choice = JOptionPane.showInputDialog("Hello Player " + players[0] + ", please pick an envelope (A, B, C)");

        switch (choice.toUpperCase()) {
            case "A":
                return 0;
            case "B":
                return 1;
            case "C":
                return 2;
            default:
                JOptionPane.showMessageDialog(null, "Invalid choice! Defaulting to envelope A.");
                return 0;
        }
    }

    public static int eliminatePlayers(int[] envelopes, String[] players, int prizeIndex, int playerChoiceIndex) {
        JFrame f = new JFrame();
        Random rand = new Random();

        int revealedIndex;
        do {
            revealedIndex = rand.nextInt(3);
        } while (revealedIndex == prizeIndex || revealedIndex == playerChoiceIndex); 

        if (envelopes[revealedIndex] == 1) {
            JOptionPane.showMessageDialog(f, "The revealed envelope contained the prize. You lost!");
            int winnerIndex;
            do {
                winnerIndex = rand.nextInt(3);
            } while (winnerIndex == playerChoiceIndex);
            
            JOptionPane.showMessageDialog(f, "Player " + players[winnerIndex] + " is the winner!");
            return -1; 
        }

        envelopes[revealedIndex] = -1;
        JOptionPane.showMessageDialog(f, "Envelope " + (char) ('A' + revealedIndex) + " has been revealed and is empty.");

        return revealedIndex;
    }

    public static boolean switchDoors(int[] envelopes, int playerChoiceIndex, int revealedIndex, int prizeIndex) {
        JFrame f = new JFrame();
        int remainingIndex = 3 - (playerChoiceIndex + revealedIndex);
        int switchChoice = JOptionPane.showConfirmDialog(f,
                "Would you like to switch to envelope " + (char) ('A' + remainingIndex) + "?",
                "Switch Envelopes", JOptionPane.YES_NO_OPTION);
        if (switchChoice == JOptionPane.YES_OPTION) {
            playerChoiceIndex = remainingIndex;
        }
        return playerChoiceIndex == prizeIndex;
    }
}

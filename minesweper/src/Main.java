import javax.swing.*;
import java.awt.*;

public class Main {

    static int n;
    static double dificultate;
    static String playerName;
    static JFrame frame = new JFrame("MINESWEEPER");

    public static String getPlayerName() {
        return playerName;
    }

    public static void main(String[] args) {

        playerName = JOptionPane.showInputDialog(frame, "Introduceti numele jucatorului:");

        String[] marimeOptions = {"Mic", "Mediu", "Mare"};
        String marimeChoice = (String) JOptionPane.showInputDialog(frame, "Selectati marimea:", "Marimea",
                JOptionPane.QUESTION_MESSAGE, null, marimeOptions, marimeOptions[0]);

        String[] dificultateOptions = {"Usor", "Mediu", "Dificil"};
        String dificultateChoice = (String) JOptionPane.showInputDialog(frame, "Selectati dificultatea:", "Dificultate",
                JOptionPane.QUESTION_MESSAGE, null, dificultateOptions, dificultateOptions[0]);

        switch (dificultateChoice) {
            case "Usor":
                Setari.setDificultate(0.89);
                break;
            case "Mediu":
                Setari.setDificultate(0.86);
                break;
            case "Dificil":
                Setari.setDificultate(0.83);
                break;
            default:
                Setari.setDificultate(0.86);
        }

        switch (marimeChoice) {
            case "Mic":
                Setari.setN(9);
                break;
            case "Mediu":
                Setari.setN(12);
                break;
            case "Mare":
                Setari.setN(15);
                break;
            default:
                Setari.setN(12);
        }

        n=Setari.getN();
        dificultate=Setari.getDificultate();
        int[][] grid = new int[n+1][n];
        Setari.setGrid(grid);
        Tabla.creareTabela(n, dificultate, grid);
        Tabla.atribuireButoane(n, grid, frame);

        frame.add(new TestPane());
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if (n >= 10) {
            frame.setSize(45 * n, 45 * n);
        } else {
            frame.setSize(400, 400);
        }

        frame.setLayout(new GridLayout(n + 1, n));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class ButtonMouseListener extends MouseAdapter {
    private final JButton[][] buttons;
    private final int row;
    private final int col;
    static int miscari = Setari.getMiscari();
    static int n = Setari.getN();
    static double dificultate = Setari.getDificultate();
    static int[][] grid = Setari.getGrid();

    public ButtonMouseListener(JButton[][] buttons, int row, int col) {
        this.buttons = buttons;
        this.row = row;
        this.col = col;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) { // Click stanga
            handleLeftClick();
        } else if (e.getButton() == MouseEvent.BUTTON3) { // Click dreapta
            handleRightClick();
        }
    }

    private void handleLeftClick() {
        if (buttons[row][col].getBackground().equals(Color.darkGray)) {
            if (miscari == 0 && grid[row][col]==9) {
                while (grid[row][col]==9) {
                    Tabla.creareTabela(n, dificultate, grid);
                    Tabla.actualizareButoane(n, grid, buttons);
                    System.out.println();
                }
                miscari = miscari + 1;
                if (grid[row][col]==0) {
                    Functii.setNeighboringButtonsGray(grid,buttons, row, col);
                    Functii.checkwin(grid,buttons);
                } else {
                    buttons[row][col].setBackground(Color.GRAY);
                    Functii.checkwin(grid,buttons);
                    buttons[row][col].setText(String.valueOf(grid[row][col]));
                }
            } else {
                miscari = miscari + 1;
                if (grid[row][col]==9) {
                    buttons[row][col].setBackground(Color.RED);
                    Functii.setNeighboringButtonsRed(grid,buttons);
                    Functii.showGameOverMessage();
                } else if (grid[row][col]==0) {
                    Functii.setNeighboringButtonsGray(grid,buttons, row, col);
                    Functii.checkwin(grid,buttons);
                } else {
                    buttons[row][col].setBackground(Color.GRAY);
                    buttons[row][col].setText(String.valueOf(grid[row][col]));
                    Functii.checkwin(grid,buttons);
                }
            }
        }
    }

    private void handleRightClick() {
        if (buttons[row][col].getBackground().equals(Color.darkGray)){
            buttons[row][col].setBackground(Color.BLUE);
        } else if (buttons[row][col].getBackground().equals(Color.BLUE)) {
            buttons[row][col].setBackground(Color.darkGray);
        }
    }
}

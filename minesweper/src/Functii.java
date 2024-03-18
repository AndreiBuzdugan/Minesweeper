import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Functii {

    static int n=Setari.getN();

    static long scor=0;


    public static void setNeighboringButtonsGray(int[][] grid,JButton[][] buttons, int row, int col) {
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i >= 0 && i < n && j >= 0 && j < n && buttons[i][j].getBackground().equals(Color.darkGray)) {
                    if (grid[i][j]==0) {
                        buttons[i][j].setBackground(Color.GRAY);
                        setNeighboringButtonsGray(grid,buttons, i, j);
                    } else {
                        buttons[i][j].setBackground(Color.GRAY);
                        buttons[i][j].setText(String.valueOf(grid[i][j]));
                    }
                }
            }
        }
    }

    public static void setNeighboringButtonsRed(int[][] grid , JButton[][] buttons) {
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]==9 && buttons[i][j].getBackground().equals(Color.darkGray)) {
                    buttons[i][j].setBackground(Color.RED);
                }
                if (grid[i][j]==9 && buttons[i][j].getBackground().equals(Color.BLUE)) {
                    buttons[i][j].setBackground(Color.GREEN);
                }

            }
        }
    }

    public static void checkwin(int[][] grid , JButton[][] buttons){
        int count=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]==9 || buttons[i][j].getBackground().equals(Color.GRAY)){
                    count++;
                }
            }
        }

        if(count==n*n) {
            String nume=Main.getPlayerName();
            if(nume.isEmpty()){
                nume="player";
            }
            String surpriza;
            scor=Math.round((1-Setari.getDificultate())*n*((10-TestPane.getMin())*60+60-TestPane.getCounttime()));
            Functii.setNeighboringButtonsRed(grid,buttons);
            JDialog dialog = new JDialog();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setTitle("Game over");
            dialog.setSize((250+(nume.length()*2)), 100);
            dialog.setLocationRelativeTo(null);
            dialog.setLayout(new BorderLayout());

            if(scor>700){
                surpriza=" high ";
            }else if(scor>150){
                surpriza=" ";
            }else{
                surpriza=" low ";
            }

            String anunt=nume +" win with a"+ surpriza +"score of : " + scor;

            JLabel label = new JLabel(anunt, SwingConstants.CENTER);



            File fisierScor = new File("scor.txt");
            try {
                if (!fisierScor.exists()) {
                    fisierScor.createNewFile();
                }
                FileWriter writer = new FileWriter(fisierScor, true);
                writer.append(anunt + "\n");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }




            JButton closeButton = new JButton("Close");
            closeButton.setBackground(Color.GREEN);

            closeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });

            dialog.add(label, BorderLayout.CENTER);
            dialog.add(closeButton, BorderLayout.SOUTH);
            dialog.setVisible(true);
        }
    }

    public static void showGameOverMessage() {
        JDialog dialog = new JDialog();
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setTitle("Game Over");
        dialog.setSize(250, 100);
        dialog.setLocationRelativeTo(null);
        dialog.setLayout(new BorderLayout());

        JLabel label = new JLabel("You lose", SwingConstants.CENTER);
        label.setSize(250,100);
        JButton closeButton = new JButton("Close");
        closeButton.setBackground(Color.RED);

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        dialog.add(label, BorderLayout.CENTER);
        dialog.add(closeButton, BorderLayout.SOUTH);

        dialog.setVisible(true);
    }
}

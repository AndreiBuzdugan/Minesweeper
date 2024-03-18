import javax.swing.*;
import java.awt.*;

public class Tabla {

    public static void creareTabela(int n,double dificultate , int[][] grid){
        for( int i=0; i < n ; i++ ) {
            for( int j=0; j < n ; j++ ) {
                if(Math.random()>dificultate){
                    grid[i][j]=9;
                }else{
                    grid[i][j]=0;
                }
            }
        }

        for( int i=0; i < n ; i++ ) {
            for (int j = 0; j < n; j++) {
                for(int k=i+1 ; k>=i-1;k-- ){
                    for(int m=j+1;m>=j-1;m--){
                        if(k>=0 && k<n && m>=0 && m<n){
                            if(grid[k][m]==9 && grid[i][j]!=9) {
                                grid[i][j]++;
                            }
                        }
                    }
                }
            }
        }

        for( int i=0; i < n ; i++ ) {
            System.out.println();
            for( int j=0; j < n ; j++ ) {
                System.out.print(grid[i][j] + " ");
            }
        }
        System.out.println();
    }


    public static void atribuireButoane(int n, int[][] grid,JFrame frame){
        JButton[][] buttons = new JButton[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                buttons[i][j] = new JButton("");
                frame.add(buttons[i][j]);
                buttons[i][j].setBackground(Color.darkGray);
                buttons[i][j].addMouseListener(new ButtonMouseListener(buttons, i, j));
                frame.invalidate();
                frame.validate();
                frame.repaint();
            }
        }
    }

    public static void actualizareButoane(int n, int[][] grid,JButton[][] buttons){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                buttons[i][j].setText("");
            }
        }
    }


}

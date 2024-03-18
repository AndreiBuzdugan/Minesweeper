public class Setari {

    static int n ;
    static double dificultate ;
    static int[][] grid = new int[n+1][n];
    static int miscari=0;

    public static int getMiscari() {
        return miscari;
    }

    public static int[][] getGrid() {
        return grid;
    }

    public static int getN() {
        return n;
    }

    public static double getDificultate() {
        return dificultate;
    }

    public static void setN(int n) {
        Setari.n = n;
    }

    public static void setGrid(int[][] grid) {
        Setari.grid = grid;
    }

    public static void setDificultate(double dificultate) {
        Setari.dificultate = dificultate;
    }
}

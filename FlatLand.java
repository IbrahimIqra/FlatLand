import java.io.IOException;
import java.util.Scanner;

public class FlatLand
{
    protected static char[][] grid;
    
    public void createWorld() {
        fullscreen();
        final Scanner scan = new Scanner(System.in);
        System.out.println("Enter the length and height of the \"2D FLAT_WORLD\"");
        System.out.println("Entering 10 then entering 10 will create a 10x10 2D World");
        final int x = scan.nextInt();
        final int y = scan.nextInt();
        FlatLand.grid = new char[y][x];
        this.showWorld();
    }
    
    static void fullscreen() {
        try {
            new ProcessBuilder(new String[] { "cmd", "/c", "mode 800" }).inheritIO().start().waitFor();
        }
        catch (IOException | InterruptedException ex2) {
            // final Exception ex = new E;
            // final Exception e1 = ex;
            System.out.println(ex2);
        }
    }
    
    protected void clear() {
        try {
            new ProcessBuilder(new String[] { "cmd", "/c", "cls" }).inheritIO().start().waitFor();
            new ProcessBuilder(new String[] { "cmd", "/c", "if not \"%1\" == \"max\" start /MAX cmd /c %0 max & exit/b" }).inheritIO().start().waitFor();
        }
        catch (IOException | InterruptedException ex2) {
            // final Exception ex;
            // final Exception e1 = ex;
            System.out.println(ex2);
        }
    }
    
    public void showWorld() {
        this.clear();
        System.out.println("\t/\\");
        System.out.println("\t||");
        System.out.println("\tNorth");
        System.out.println("West<--     -->East");
        System.out.println("\t||");
        System.out.println("\t\\/");
        System.out.println("\tSouth");
        int t1 = FlatLand.grid[0].length;
        while (t1-- > 0) {
            System.out.print("---");
        }
        System.out.println();
        for (int i = 0; i < FlatLand.grid.length; ++i) {
            for (int j = 0; j < FlatLand.grid[i].length; ++j) {
                System.out.print("|  ");
            }
            System.out.println("|");
            int t2 = FlatLand.grid[0].length;
            while (t2-- > 0) {
                System.out.print("---");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    protected void printX(final int x, final int y) {
        FlatLand.grid[y][x] = 'X';
    }
    
    protected boolean chkWarning(final int x, final int y) {
        return FlatLand.grid[y][x] == 'X';
    }
    
    protected boolean chkLimitCross(final int x, final int y) {
        return x < 0 || y < 0 || x > FlatLand.grid[0].length - 1 || y > FlatLand.grid.length - 1;
    }
}
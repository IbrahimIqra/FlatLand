import java.util.Scanner;

public class FlatDriver
{
    public static void main(final String[] args) {
        final Scanner scan = new Scanner(System.in);
        FlatLand worldObj = new FlatLand();
        worldObj.createWorld();
        System.out.println("Now Let's Create a FlatBeing");
        System.out.println("\nHighest Value of 'X' coordinate can be " + (FlatLand.grid[0].length - 1));
        System.out.println("Highest Value of 'Y' coordinate can be " + (FlatLand.grid.length - 1));
        while (true) {
            System.out.println("\nEnter the starting position and direction\n");
            System.out.println("Enter value of x coordinate");
            final int x_pos = scan.nextInt();
            System.out.println("Enter value of y coordinate");
            final int y_pos = scan.nextInt();
            System.out.println("Enter direction. For Example: N for North, S for South, E for East, W for West");
            final char d = scan.next().charAt(0);
            final FlatBeing rObj = new FlatBeing(x_pos, y_pos, d);
            scan.nextLine();
            rObj.showWorld();
            do {
                System.out.println("Valid commands R,F,L\n");
                System.out.println("'R' will rotate the FlatBeing to Right");
                System.out.println("'L' will rotate the FlatBeing to Left");
                System.out.println("'F' will forward to FlatBeing to the next box");
                System.out.println("You can enter multiple commands like RFLLFRFL\n");
                System.out.println("Enter your commands Or Enter KILL or 0 to Destroy the FlatBeing");
                final String s = scan.nextLine();
                if (s.equals("KILL") || s.equals("kill")) {
                    break;
                }
                if (s.equals("0")) {
                    break;
                }
                rObj.allCommand(s);
                System.out.println(rObj.getPos());
                rObj.showWorld();
            } while (!rObj.lost);
            System.out.println("Enter 1 to Create another FlatBeing\nEnter 2 to Create a new 2D World");
            System.out.println("Enter END or 0 to QUIT!");
            final String s = scan.nextLine();
            if (s.equals("END") || s.equals("end") || s.equals("0")) {
                break;
            }
            if (!s.equals("2")) {
                continue;
            }
            worldObj = new FlatLand();
            worldObj.createWorld();
        }
    }
}
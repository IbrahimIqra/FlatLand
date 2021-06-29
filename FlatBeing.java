public class FlatBeing extends FlatLand
{
    private int x;
    private int y;
    private char dir;
    public boolean lost;
    
    FlatBeing(final int x, final int y, final char ch) {
        this.x = x;
        this.y = y;
        if (ch == 'n') {
            this.dir = 'N';
        }
        else if (ch == 'e') {
            this.dir = 'E';
        }
        else if (ch == 's') {
            this.dir = 'S';
        }
        else {
            this.dir = 'W';
        }
    }
    
    @Override
    public void showWorld() {
        this.clear();
        int t1 = FlatBeing.grid[0].length;
        while (t1-- > 0) {
            System.out.print("---");
        }
        System.out.println();
        for (int i = 0; i < FlatBeing.grid.length; ++i) {
            for (int j = 0; j < FlatBeing.grid[i].length; ++j) {
                if (FlatBeing.grid.length - i == this.y + 1 && j == this.x) {
                    String tmp;
                    if (this.dir == 'N') {
                        tmp = "|/\\";
                    }
                    else if (this.dir == 'E') {
                        tmp = "|->";
                    }
                    else if (this.dir == 'W') {
                        tmp = "|<-";
                    }
                    else {
                        tmp = "|\\/";
                    }
                    System.out.print(tmp);
                }
                else {
                    System.out.print("|  ");
                }
            }
            System.out.println("|");
            int t2 = FlatBeing.grid[0].length;
            while (t2-- > 0) {
                System.out.print("---");
            }
            System.out.println();
        }
        System.out.println(this.getPos());
        String direction = "";
        if (this.dir == 'N') {
            direction = "North";
        }
        else if (this.dir == 'E') {
            direction = "East";
        }
        else if (this.dir == 'W') {
            direction = "West";
        }
        else {
            direction = "South";
        }
        System.out.println("\nFlatBeing is facing " + direction);
        if (this.lost) {
            System.out.println("\n!!!!!!YOUR FlatBeing IS LOST AND DESTROYED!!!!!!\nCreate a new one!!\n");
        }
    }
    
    void allCommand(final String s) {
        this.lost = false;
        for (int i = 0; i < s.length(); ++i) {
            this.move(s.charAt(i));
            if (this.lost) {
                break;
            }
        }
    }
    
    private void move(final char eachCommand) {
        if (eachCommand == 'F' || eachCommand == 'f') {
            if (this.dir == 'N') {
                ++this.y;
                if (this.chkLimitCross(this.x, this.y)) {
                    --this.y;
                    if (!this.chkWarning(this.x, this.y)) {
                        this.printX(this.x, this.y);
                        this.lost = true;
                    }
                }
            }
            else if (this.dir == 'E') {
                ++this.x;
                if (this.chkLimitCross(this.x, this.y)) {
                    --this.x;
                    if (!this.chkWarning(this.x, this.y)) {
                        this.printX(this.x, this.y);
                        this.lost = true;
                    }
                }
            }
            else if (this.dir == 'S') {
                --this.y;
                if (this.chkLimitCross(this.x, this.y)) {
                    ++this.y;
                    if (!this.chkWarning(this.x, this.y)) {
                        this.printX(this.x, this.y);
                        this.lost = true;
                    }
                }
            }
            else {
                --this.x;
                if (this.chkLimitCross(this.x, this.y)) {
                    ++this.x;
                    if (!this.chkWarning(this.x, this.y)) {
                        this.printX(this.x, this.y);
                        this.lost = true;
                    }
                }
            }
        }
        else {
            this.rotate(eachCommand);
        }
    }
    
    private void rotate(final char LR) {
        if (this.dir == 'N') {
            if (LR == 'R' || LR == 'r') {
                this.dir = 'E';
            }
            else {
                this.dir = 'W';
            }
        }
        else if (this.dir == 'E') {
            if (LR == 'R' || LR == 'r') {
                this.dir = 'S';
            }
            else {
                this.dir = 'N';
            }
        }
        else if (this.dir == 'S') {
            if (LR == 'R' || LR == 'r') {
                this.dir = 'W';
            }
            else {
                this.dir = 'E';
            }
        }
        else if (LR == 'R' || LR == 'r') {
            this.dir = 'N';
        }
        else {
            this.dir = 'S';
        }
    }
    
    String getPos() {
        return "Current Position " + this.x + " " + this.y;
    }
}
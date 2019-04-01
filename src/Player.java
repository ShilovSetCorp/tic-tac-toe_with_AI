import java.util.Random;
import java.util.Scanner;

public abstract class Player {
    protected String name;
    protected FieldContent type;
    private int turn;
    protected boolean winner;



    public Player(String type) {
        if(type.equals("0"))
            this.type = FieldContent.ZERO;
        else if(type.equals("X"))
            this.type = FieldContent.CROSS;
        this.winner = false;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public int getTurn() {
        return turn;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void turnRandom(Player otherPlayer){
        Random random = new Random();
        this.turn = random.nextInt(1);
        if(this.turn == 1){
            otherPlayer.setTurn(0);
            System.out.println(this.name + " moves first");
            System.out.println(otherPlayer.getName() + " moves second");
        }else{
            otherPlayer.setTurn(1);
            System.out.println(otherPlayer.getName() + " moves first");
            System.out.println(this.name + " moves second");
        }

    }

    public abstract void move(GameBoard gb);

    public boolean isWinner(GameBoard gb){
        if(checkDiagonal(gb) || checkLanes(gb)){
            this.winner = true;
            return true;
        }else {
            return false;
        }
    }

    /** Проверяем диагонали */
    public boolean checkDiagonal(GameBoard gb) {
        boolean toright, toleft;
        toright = true;
        toleft = true;
        for (int i=0; i<gb.getDeskSize(); i++) {
            toright &= (gb.getDeskCoordinates()[i][i] == this.type);
            toleft &= (gb.getDeskCoordinates()[gb.getDeskSize()-i-1][i] == this.type);
        }

        if (toright || toleft) return true;

        return false;
    }

    /** Проверяем горизонтальные и вертикальные линии */
    boolean checkLanes(GameBoard gb) {
        boolean cols, rows;
        for (int col=0; col<gb.getDeskSize(); col++) {
            cols = true;
            rows = true;
            for (int row=0; row<gb.getDeskSize(); row++) {
                cols &= (gb.getDeskCoordinates()[col][row] == this.type);
                rows &= (gb.getDeskCoordinates()[row][col] == this.type);
            }

            // Это условие после каждой проверки колонки и столбца
            // позволяет остановить дальнейшее выполнение, без проверки
            // всех остальных столбцов и строк.
            if (cols || rows) return true;
        }

        return false;
    }

}

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class GameBoard {
    private FieldContent[][] deskCoordinates;
    Set set = new TreeSet();

    public int getDeskSize() {
        return deskSize;
    }

    private int deskSize;
    private boolean isFinished;

    public FieldContent[][] getDeskCoordinates() {
        return deskCoordinates;
    }

    public GameBoard() {
        int deskSize = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter field size ");
        do {
            deskSize = sc.nextInt();
            if(deskSize < 3){
                System.out.println("The field is too small, enter bigger size please.");
            }
        }while (deskSize < 3);
        this.deskSize = deskSize;
        deskCoordinates = new FieldContent[this.deskSize][this.deskSize];
        for (int i = 0; i < this.deskSize; i++) {
            for (int j = 0; j < this.deskSize; j++) {
                deskCoordinates[i][j] = FieldContent.EMPTY;
            }
        }
    }

    public void setValue(int x, int y, FieldContent value){
        deskCoordinates[x][y] = value;
    }

    public FieldContent getValue(int x, int y){
        return deskCoordinates[x][y];
    }

    public boolean isGameFinished(Player plX, Player pl0){
        int cnt = 0;
        for (int i = 0; i < deskSize; i++) {
            for (int j = 0; j < deskSize - 1; j++) {
                if(deskCoordinates[i][j].equals(deskCoordinates[i][j+1]) && !deskCoordinates[i][j].equals(FieldContent.EMPTY)){
                    cnt++;
                }
            }
            if(cnt == deskSize -1){
                return true;
            }else {
                cnt = 0;
            }
        }
        return false;
    }

    public boolean isAnyEmpty(){
        for (int i = 0; i < this.deskSize; i++) {
            for (int j = 0; j < this.deskSize; j++) {
                if(deskCoordinates[i][j].equals(FieldContent.EMPTY)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isAlreadyOccupied(int x,int y){
        return !deskCoordinates[x][y].equals(FieldContent.EMPTY);
    }
}

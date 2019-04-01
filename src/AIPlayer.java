import java.util.Random;

public class AIPlayer extends Player{
    private int aiLevel = 1;

    public AIPlayer(String type) {
        super(type);
        this.name = "Computer";
    }

    public int getAiLevel() {
        return aiLevel;
    }

    public void setAiLevel(int aiLevel) {
        this.aiLevel = aiLevel;
    }

    @Override
    public void move(GameBoard gb) {
        int x = -1;
        int y = -1;
        if(aiLevel == 1) {
            for (int i = 0; i < gb.getDeskSize(); i++) {
                for (int j = 0; j < gb.getDeskSize(); j++) {
                    if (!gb.isAlreadyOccupied(i, j)) {
                        gb.setValue(i, j, this.type);
                        return;
                    }
                }
            }
        }
        if(aiLevel == 3){
            for (int i = 0; i < gb.getDeskSize(); i++) {
                for (int j = 0; j < gb.getDeskSize(); j++) {
                    if(!gb.isAlreadyOccupied(i, j)){
                        gb.setValue(i, j, this.type);
                        if(this.isWinner(gb)) {
                            x = i;
                            y = j;
                            this.winner = true;
                        }
                        gb.setValue(i, j, FieldContent.EMPTY);
                    }
                }
            }
        }
        //blocking user's move
        if(aiLevel > 1){
            if(!this.winner){
                for (int i = 0; i < gb.getDeskSize(); i++) {
                    for (int j = 0; j < gb.getDeskSize(); j++) {
                        if(!gb.isAlreadyOccupied(i, j)){
                            gb.setValue(i, j, this.type);
                            if(this.isWinner(gb)) {
                                x = i;
                                y = j;
                                this.winner = true;
                            }
                            gb.setValue(i, j, FieldContent.EMPTY);
                        }
                    }
                }
            }
        }
        if(!this.winner) {
            do{
                Random rnd = new Random();
                x = rnd.nextInt(gb.getDeskSize());
                y = rnd.nextInt(gb.getDeskSize());
            }while (gb.isAlreadyOccupied(x, y));
        }
        gb.setValue(x, y, this.type);
    }
}

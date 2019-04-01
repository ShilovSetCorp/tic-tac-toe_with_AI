import java.util.Scanner;

public class MainGame {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        GameBoard gameBoard = new GameBoard();
        ViewDesk view = new ViewDesk(gameBoard.getDeskCoordinates());
        view.showDesk();
        Player playerX;
        Player player0;
        System.out.println("Player Cross AI or Human? (A/H):");
        if(sc.nextLine().equals("A")) {
            playerX = new AIPlayer("X");
            System.out.println("Please choose level of Cross AI (1/2/3): ");
            ((AIPlayer)playerX).setAiLevel(sc.nextInt());
            sc.nextLine();
        }else {
            playerX = new HumanPlayer("X");
        }
        System.out.println("Player Zero AI or Human? (A/H):");
        if(sc.nextLine().equals("A")) {
            player0 = new AIPlayer("0");
            System.out.println("Please choose level of Cross AI (1/2/3): ");
            ((AIPlayer)player0).setAiLevel(sc.nextInt());
        }else {
            player0 = new HumanPlayer("0");
        }

        playerX.turnRandom(player0);
        while (true){
            if(!gameBoard.isAnyEmpty()){
                System.out.println("This is draw!");
                break;
            }
            if(player0.getTurn() == 1){
                System.out.println("Player Zero moves!");
                player0.move(gameBoard);
                view.showDesk();
                if(player0.isWinner(gameBoard)){
                    System.out.println(player0.getName() + " is winner!");
                    break;
                }
                System.out.println("Player Cross moves!");
                playerX.move(gameBoard);
                view.showDesk();
                if(playerX.isWinner(gameBoard)){
                    System.out.println(playerX.getName() + " is winner!");
                    break;
                }

            }else{
                System.out.println("Player Cross moves!");
                playerX.move(gameBoard);
                view.showDesk();
                if(playerX.isWinner(gameBoard)){
                    System.out.println(playerX.getName() + " is winner!");
                    break;
                }
                System.out.println("Player Zero moves!");
                player0.move(gameBoard);
                view.showDesk();
                if(player0.isWinner(gameBoard)){
                    System.out.println(player0.getName() + " is winner!");
                    break;
                }
            }
        }

    }
}

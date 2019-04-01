import java.util.Scanner;

public class HumanPlayer extends Player {
    private Scanner sc = new Scanner(System.in);


    public HumanPlayer(String type) {
        super(type);
        System.out.println("Player " + this.type + " type your name:");
        this.name = sc.nextLine();
    }

    public void move(GameBoard gb){
        boolean correct = false;
        int x  =0;
        int y = 0;
        System.out.println("Player " + this.name + ", input your coordinates");
        do {
            String sX = sc.next();
            String sY = sc.next();
            if(sX.matches("[\\d+]") && sY.matches("[\\d+]")) {
                x = Integer.parseInt(sX);//sc.nextInt();
                y = Integer.parseInt(sY);//sc.nextInt();
                if (x <= gb.getDeskSize() && y <= gb.getDeskSize()) {
                    if (!gb.isAlreadyOccupied(x - 1, y - 1)) {
                        correct = true;
                    } else {
                        System.out.println("This cell is occupied! Watch better! Try again!");
                    }
                } else {
                    System.out.println("Your coordonats are incorrect, please enter them again");
                }
            }else
            {
                System.out.println("You've entered some bullshit! Try again!");
            }
        }while (!correct);

        gb.setValue(x - 1,y - 1,this.type);

    }
}

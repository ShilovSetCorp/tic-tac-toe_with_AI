public class ViewDesk {
    private FieldContent[][] desk;

    public ViewDesk(FieldContent[][] desk) {
        this.desk = desk;
    }

    public void showDesk(){
        System.out.println("******************");
        for (int i = 0; i < desk.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < desk.length; j++) {
                switch (desk[i][j]){
                    case ZERO:
                        System.out.print("0 ");
                        break;
                    case CROSS:
                        System.out.print("X ");
                        break;
                    case EMPTY:
                        System.out.print("_ ");
                }
            }
            System.out.println("| ");
        }
    }


}

package main;

public class Rules {

    public static boolean schroedingerCell(boolean fieldValue, int activeNeighbours){
        return switch (activeNeighbours) {
            case 2 -> fieldValue;
            case 3 -> true;
            default -> false;
        };
    }

}

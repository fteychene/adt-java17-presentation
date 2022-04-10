package xyz.fteychene.abstractclass;

import static xyz.fteychene.abstractclass.Direction.*;

public class WallE {

    // Should do something more visual
    public void display(String message) {
        System.out.println("\uD83E\uDD16 : "+ message);
    }

    public void handle(Command command) {
        switch (command) {
            case Move m -> display("Move of "+ m.getSteps());
            case Turn t -> {
                switch (t.getDirection()) {
                    case NORTH -> display("Turning north");
                    case SOUTH -> display("Turning south");
                    case WEST -> display("Turning west");
                    case EAST -> display("Turning east");
                }
            }
            case Cute e -> display("Do some science");
            case TakeOver t -> display("Start taking over the WORLD !!!!!!!");
            default -> throw new IllegalArgumentException("don't know command "+command);
        }
    }

    public static void main(String[] args) {
        try {
            var rover = new WallE();
            rover.handle(new Turn(Direction.NORTH));
            rover.handle(new Move(5));
            rover.handle(new Cute());
            rover.handle(new Turn(EAST));
            rover.handle(new Move(3));
            rover.handle(new TakeOver());
        } catch (Exception e) {
            System.out.println("Confusion \uD83D\uDCA5\uD83D\uDCA5\uD83D\uDCA5 (" + e.getMessage() + ")");
        }
    }
}

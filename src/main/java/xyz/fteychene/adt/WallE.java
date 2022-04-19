package xyz.fteychene.adt;

import static xyz.fteychene.adt.Direction.*;

public class WallE {

    // Should do something more visual
    public void display(String message) {
        System.out.println("\uD83E\uDD16 : "+ message);
    }

    public void handle(Command command) {
        switch (command) {
            case Move m -> display("Move of "+ m.steps());
            case Turn t -> {
                switch (t.direction()) {
                    case NORTH -> display("Turning north");
                    case SOUTH -> display("Turning south");
                    case WEST -> display("Turning east");
                    case EAST -> display("Turning west");
                }
            }
            case Cute cute -> display("Do something cute no one can resist");
            case TakeOver takeOver -> display("Start taking over the WORLD !!!!!!!");
            case Chain chain -> {
                handle(chain.a());
                handle(chain.b());
            }
        }
    }

    public static void main(String[] args) {
        try {
            var commands = new Turn(NORTH)
                    .then(new Move(5))
                    .then(new Cute())
                    .then(new Move(3))
                    .then(new Turn(EAST))
                    .then(new TakeOver());
            var rover = new WallE();
            rover.handle(commands);
        } catch (Exception e) {
            System.out.println("Confusion \uD83D\uDCA5\uD83D\uDCA5\uD83D\uDCA5 (" + e.getMessage() + ")");
        }
    }
}

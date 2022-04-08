package xyz.fteychene.adt;

import static xyz.fteychene.adt.Direction.*;

public class Rover {

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
            case Experiment e -> display("Do some science");
            case Chain chain -> {
                handle(chain.a());
                handle(chain.b());
            }
        }
    }

    public static void main(String[] args) {
        try {
            var commands = new Move(5)
                    .then(new Turn(NORTH))
                    .then(new Move(3))
                    .then(new Turn(EAST))
                    .then(new Experiment());
            var rover = new Rover();
            rover.handle(commands);
        } catch (Exception e) {
            System.out.println("Confusion \uD83D\uDCA5\uD83D\uDCA5\uD83D\uDCA5 (" + e.getMessage() + ")");
        }
    }
}

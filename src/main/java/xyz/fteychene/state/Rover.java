package xyz.fteychene.state;

import xyz.fteychene.state.command.Chain;
import xyz.fteychene.state.command.Command;
import xyz.fteychene.state.command.Experiment;
import xyz.fteychene.state.command.Move;
import xyz.fteychene.state.command.Start;
import xyz.fteychene.state.command.Stop;
import xyz.fteychene.state.command.Turn;
import xyz.fteychene.state.command.Wait;
import xyz.fteychene.state.state.Moving;

import static xyz.fteychene.state.command.Direction.NORTH;
import static xyz.fteychene.state.command.Move.Move;
import static xyz.fteychene.state.command.Turn.Turn;

public class Rover {

    // Should do something more visual
    public static void display(String message) {
        System.out.println("\uD83E\uDD16 : " + message);
    }

    private static void handle(Command<?, ?> command) {
        switch (command) {
            case Move m -> display("Move of " + m.steps());
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
            case Start start -> display("Start motors");
            case Stop stop -> display("Stop motors");
            case Wait wait -> display("Science done");
        }
    }

    private static void displayMoving(Command<Moving, ?> command) {
        switch (command) {
            case Move m -> System.out.println("Move of " + m.steps());
            case Chain chain -> {
                handle(chain.a());
                handle(chain.b());
            }
            // Sad cause we can know it at compile time but "pattern matching" can't tell it ATM
            default -> throw new UnsupportedOperationException("Unsupported value : " + command);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Display moving ===");
        displayMoving(Move(5));
        // displayMoving(Turn(Direction.NORTH)); // will not compile cause Turn is Command<Idle, Idle>

        var commands = new Start()
                .then(Move(5))
                .then(new Stop())
                .then(Turn(NORTH))
                .then(new Start())
                .then(Move(3))
                .then(new Stop())
                .then(new Experiment())
                .then(new Wait());
        handle(commands);

    }
}

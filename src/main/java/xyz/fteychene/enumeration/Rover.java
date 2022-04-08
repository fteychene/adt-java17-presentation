package xyz.fteychene.enumeration;

import static xyz.fteychene.enumeration.Command.*;
import static xyz.fteychene.enumeration.Direction.*;

public class Rover {

    // Should do something more visual
    public void display(String message) {
        System.out.println("\uD83E\uDD16 : "+ message);
    }

    public void handle(Command command, Object param) {
        switch (command) {
            case MOVE -> {
                if (! (param instanceof Integer)) {
                    throw new IllegalArgumentException("param is not a valid move");
                }
                display("Move of "+ param);
            }
            case TURN -> {
                switch ((Direction) param) {
                    case NORTH -> display("Turning north");
                    case SOUTH -> display("Turning south");
                    case WEST -> display("Turning east");
                    case EAST -> display("Turning west");
                }
            }
            case EXPERIMENT -> display("Do some science");
        };
    }

    public static void main(String[] args) {
        try {
            var rover = new Rover();
            rover.handle(MOVE, 5);
            rover.handle(TURN, NORTH);
            rover.handle(MOVE, "3");
            rover.handle(TURN, EAST);
            rover.handle(EXPERIMENT, null);
        } catch (Exception e) {
            System.out.println("Confusion \uD83D\uDCA5\uD83D\uDCA5\uD83D\uDCA5 (" + e.getMessage() + ")");
        }
    }
}

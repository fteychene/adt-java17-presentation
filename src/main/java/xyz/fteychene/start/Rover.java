package xyz.fteychene.start;

public class Rover {

    // Should do something more visual
    public void display(String message) {
        System.out.println("\uD83E\uDD16 : "+ message);
    }

    public void handle(String command) {
        if (command.startsWith("move")) {
           display("Move of "+ Integer.valueOf(command.split(" ")[1]));
        } else if (command.startsWith("turn")) {
            switch (command.split(" ")[1]) {
                case "north" -> display("Turning north");
                case "south" -> display("Turning south");
                case "east" -> display("Turning east");
                case "west" -> display("Turning west");
                default -> throw new IllegalArgumentException("don't know direction "+command.split(" ")[1]);
            }
        } else if (command.equals("experiment")) {
            display("Do some science");
        } else {
            throw new IllegalArgumentException("don't know command "+command);
        }

    }

    public static void main(String[] args) {
        try {
            var rover = new Rover();
            rover.handle("move 5");
            rover.handle("turn north");
            rover.handle("move 3");
            rover.handle("turn east");
            rover.handle("sit");
            rover.handle("experiment");
        } catch (Exception e) {
            System.out.println("Confusion \uD83D\uDCA5\uD83D\uDCA5\uD83D\uDCA5 (" + e.getMessage() + ")");
        }
    }
}

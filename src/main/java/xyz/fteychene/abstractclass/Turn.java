package xyz.fteychene.abstractclass;

public class Turn extends Command {

    private final Direction direction;

    public Turn(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }
}

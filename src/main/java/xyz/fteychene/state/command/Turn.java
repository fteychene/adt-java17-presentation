package xyz.fteychene.state.command;

import xyz.fteychene.state.state.Idle;

public record Turn(Direction direction) implements Command<Idle, Idle> {

    public static Turn Turn(Direction direction) {
        return new Turn(direction);
    }
}

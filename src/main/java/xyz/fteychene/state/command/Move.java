package xyz.fteychene.state.command;

import xyz.fteychene.state.state.Moving;

public record Move(Integer steps) implements Command<Moving, Moving> {

    public static Move Move(Integer steps) {
        return new Move(steps);
    }
}

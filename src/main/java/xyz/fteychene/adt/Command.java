package xyz.fteychene.adt;

public sealed interface Command permits Chain, Cute, Move, TakeOver, Turn {

    default Command then(Command next) {
        return new Chain(this, next);
    }

}

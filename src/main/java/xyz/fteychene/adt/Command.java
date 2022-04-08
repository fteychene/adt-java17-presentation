package xyz.fteychene.adt;

public sealed interface Command permits Chain, Experiment, Move, Turn {

    default Command then(Command next) {
        return new Chain(this, next);
    }

}

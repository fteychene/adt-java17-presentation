package xyz.fteychene.state.command;

public sealed interface Command<From, To> permits Chain, Experiment, Move, Start, Stop, Turn, Wait {

    default <Next> Command<From, Next> then(Command<To, Next> next) {
        return new Chain(this, next);
    }
}

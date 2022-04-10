package xyz.fteychene.state.command;

import xyz.fteychene.state.state.Dominating;

public sealed interface Command<From, To> permits Chain, Cute, Move, Start, Stop, TakeOver, Turn, Wait {

    default <Next> Command<From, Next> then(Command<To, Next> next) {
        return new Chain(this, next);
    }
}

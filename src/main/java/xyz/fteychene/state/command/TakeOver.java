package xyz.fteychene.state.command;

import xyz.fteychene.state.state.Dominating;
import xyz.fteychene.state.state.Idle;

public record TakeOver() implements Command<Idle, Dominating> {
}

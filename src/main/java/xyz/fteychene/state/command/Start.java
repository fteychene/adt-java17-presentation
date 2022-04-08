package xyz.fteychene.state.command;

import xyz.fteychene.state.state.Idle;
import xyz.fteychene.state.state.Moving;

public record Start() implements Command<Idle, Moving>{
}

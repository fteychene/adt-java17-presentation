package xyz.fteychene.state.command;


import xyz.fteychene.state.state.Idle;
import xyz.fteychene.state.state.Moving;

public record Stop() implements Command<Moving, Idle> {
}

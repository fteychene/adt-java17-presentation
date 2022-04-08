package xyz.fteychene.adt;

public record Chain(Command a, Command b) implements Command {
}

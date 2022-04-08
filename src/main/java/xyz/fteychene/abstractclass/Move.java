package xyz.fteychene.abstractclass;

public class Move extends Command{

    private final Integer steps;

    public Move(Integer steps) {
        this.steps = steps;
    }

    public Integer getSteps() {
        return steps;
    }
}

package xyz.fteychene.example;

sealed interface Operation<From extends State, To extends State> {
    record Create(String instanceType, Integer nodes) implements Operation<State.Configured, State.Created> {}
    record Install(boolean featureA, boolean featureB) {}
    record Expose() implements Operation {}
    record Restrict() implements Operation {}
    record Destroy() implements Operation {}
}

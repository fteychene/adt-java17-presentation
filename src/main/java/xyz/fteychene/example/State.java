package xyz.fteychene.example;

sealed interface State {

    record Configured() implements State {}
    record Created() implements State{}
    record Installed() implements State{}
    record Available() implements State{}

    Configured Configured = new Configured();
    Created Created = new Created();
    Installed Installed = new Installed();
    Available Available = new Available();
}

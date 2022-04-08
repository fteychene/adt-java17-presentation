package xyz.fteychene.example;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Service {

    public Environment<State.Configured> newEnv() {
        // Do a lot of things ...
        return new Environment<>(State.Configured);
    }

    public Environment<State.Created> create(Environment<State.Configured> env, Operation.Create create) {
        // Do a lot of things ...
        return new Environment<>(State.Created);
    }

    public Environment<State.Installed> install(Environment<State.Created> env, Operation.Install install) {
        // Do a lot of things ...
        return new Environment<>(State.Installed);
    }

    public Environment<State.Available> expose(Environment<State.Installed> env, Operation.Expose expose) {
        // Do a lot of things ...
        return new Environment<>(State.Available);
    }

    public Environment<State.Installed> restrict(Environment<State.Available> env, Operation.Restrict restrict) {
        // Do a lot of things ...
        return new Environment<>(State.Installed);
    }

    public Environment<State.Configured> destroy(Environment<State.Installed> env, Operation.Destroy install) {
        // Do a lot of things ...
        return new Environment<>(State.Configured);
    }


    public static void main(String[] args) {
        var service = new Service();
//        var env = service.newEnv();
//        var created = service.create(env, new Operation.Create("wololo", 3));
//        var installed = service.install(created, new Operation.Install(true, false));
//        var exposed = service.expose(installed, new Operation.Expose());
//        var unexposed = service.restrict(exposed, new Operation.Restrict());

        var env = service.newEnv();
        var updated = partial2(service::create, new Operation.Create("wololo", 3))
                .andThen(partial2(service::install, new Operation.Install(true, false)))
                .andThen(partial2(service::expose, new Operation.Expose()))
                .andThen(partial2(service::restrict, new Operation.Restrict()))
                .andThen(partial2(service::destroy, new Operation.Destroy()))
                .apply(env);

        System.out.println(updated);
    }

    public static <A, T, R> Function<T, R> partial2(BiFunction<T, A, R> f, A value) {
        return (t) -> f.apply(t, value);
    }

}

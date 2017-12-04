package com.igt;

//FIXME: Some dumb way to provide single injector components for all parts of application
public class ComponentInjector {
    private static AppComponent injector;
    private static InjectorBuilder builder = new InjectorBuilder();

    public static class InjectorBuilder {
        public AppComponent buildInjector() {
            return DaggerAppComponent.create();
        }
    }

    public static void setInjectorBuilder(InjectorBuilder builder) {
        ComponentInjector.builder = builder;
    }

    public static AppComponent getInjector() {
        if (injector == null) {
            injector = builder.buildInjector();
        }
        return injector;
    }
}

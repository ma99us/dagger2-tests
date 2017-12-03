package com.igt;

//FIXME: Some dumb way to provide single injector components for all parts of application
public class ComponentInjector {
    private static AppComponent injector;

    public static void setInjector(AppComponent injector) {
        ComponentInjector.injector = injector;
    }

    public static AppComponent getInjector() {
        return injector;
    }
}

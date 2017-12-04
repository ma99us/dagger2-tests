package com.igt.report;

import com.igt.ComponentInjector;
import com.igt.log.LegacyLogger;
import dagger.Module;
import dagger.Provides;

import javax.inject.Inject;
import javax.inject.Singleton;

@Module
public class LegacyReport {
    @Inject
    LegacyLogger logger;

    private static LegacyReport instance;

    public static LegacyReport getInstance() {
        if (instance == null) {
            instance = new LegacyReport();
        }
        return instance;
    }

    @Provides
    @Singleton
    public LegacyReport provideInstance() {
//        return getInstance();
        LegacyReport self = getInstance();  // or just call constructor here (new LegacyReport();)
        ComponentInjector.getInjector().inject(self);   // inject itself, to get it's own dependencies. If this class has @Injects itself
        return self;
    }

    public String getReport() {
        return "= report on: " + logger.getData();
    }
}

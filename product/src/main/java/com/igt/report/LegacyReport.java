package com.igt.report;

import com.igt.log.LegacyLogger;
import com.sun.istack.internal.NotNull;
import dagger.Module;
import dagger.Provides;

import javax.inject.Inject;
import javax.inject.Singleton;

@Module
public class LegacyReport {
    @Inject
    LegacyLogger logger;

    private static LegacyReport instance;

    public static LegacyReport getInstance(){
        if(instance == null){
            instance = new LegacyReport();
        }
        return instance;
    }

    @Provides
    @NotNull
    @Singleton
    public LegacyReport provideReport() {
        return new LegacyReport();
    }

    public String getReport(){
        return "= report on: " + logger.getData();
    }
}

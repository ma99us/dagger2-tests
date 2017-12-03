package com.igt.report;

import com.igt.log.LegacyLogger;
import com.sun.istack.internal.NotNull;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class ReportModule {

    @Provides
    @NotNull
    @Singleton
    public LegacyReport provideReport() {
        return new LegacyReport();
    }
}

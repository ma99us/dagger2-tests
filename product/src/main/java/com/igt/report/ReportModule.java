package com.igt.report;

import com.igt.log.LegacyLogger;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class ReportModule {

    @Provides
    @Singleton
    public LegacyReport provideReport() {
        return new LegacyReport();
    }
}

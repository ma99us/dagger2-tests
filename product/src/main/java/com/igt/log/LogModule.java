package com.igt.log;

import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class LogModule {

    @Provides
    @Singleton
    public LegacyLogger provideLogger(){
        return new LegacyLogger();
    }
}

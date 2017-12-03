package com.igt.log;

import com.sun.istack.internal.NotNull;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class LogModule {

    @Provides
    @NotNull
    @Singleton
    public LegacyLogger provideLogger(){
        return new LegacyLogger();
    }
}

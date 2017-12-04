package com.igt.log;

import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class LegacyLogger {

    private static LegacyLogger instance;

    public static LegacyLogger getInstance(){
        if(instance == null){
            instance = new LegacyLogger();
        }
        return instance;
    }

    @Provides
    @Singleton
    public LegacyLogger provideInstance(){
        return getInstance();
    }

    public String getData(){
        return "- some legacy data -";
    }
}

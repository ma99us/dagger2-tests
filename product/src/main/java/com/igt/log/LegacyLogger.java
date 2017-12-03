package com.igt.log;

import com.sun.istack.internal.NotNull;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;



public class LegacyLogger {

    private static LegacyLogger instance;

    protected LegacyLogger(){}

    public static LegacyLogger getInstance(){
        if(instance == null){
            instance = new LegacyLogger();
        }
        return instance;
    }

    public String getData(){
        return "- some legacy data -";
    }
}

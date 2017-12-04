package com.igt.log;

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

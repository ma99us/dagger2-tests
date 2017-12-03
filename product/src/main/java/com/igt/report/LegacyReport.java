package com.igt.report;

import com.igt.log.LegacyLogger;

import javax.inject.Inject;

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

    public String getReport(){
        return "= report on: " + logger.getData();
    }
}

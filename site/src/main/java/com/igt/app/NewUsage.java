package com.igt.app;

import com.igt.AppComponent;
import com.igt.ComponentInjector;
import com.igt.SiteAppComponent;
import com.igt.log.LegacyLogger;
import com.igt.log.SiteLogger;
import com.igt.report.LegacyReport;
import dagger.Component;

import javax.inject.Inject;

public class NewUsage {

    static {
        // replace injector builder from 'product' with a modified one from 'site'
        ComponentInjector.setInjectorBuilder(new ComponentInjector.InjectorBuilder(){
            @Override
            public AppComponent buildInjector() {
                return com.igt.DaggerSiteAppComponent.builder()   // (FIXME: How to make InteliJ to find this class 'DaggerSiteAppComponent' ?)
                        .legacyLogger(new SiteLogger())     //!!! now we can replace singleton modules here, instead of promoting legacy once !!!
                        .build();
            }
        });
    }


    @Inject
    LegacyLogger logger;

    @Inject
    LegacyReport report;

    public NewUsage(){
        ((SiteAppComponent)ComponentInjector.getInjector()).inject(this);   //FIXME: can it be done without casting, with generics maybe somehow?
    }

    public static void main(String[] args) {

        // create instances of classes and inject them into ObjectGraph to match with dependencies
        NewUsage app = new NewUsage();
        LegacyLogger logger = app.logger;
        System.out.println(logger.getData());

        LegacyReport report = app.report;
        System.out.println(report.getReport());

        // old singleton instance also works, because it self-injected
        report = LegacyReport.getInstance();
        System.out.println(report.getReport());

    }
}

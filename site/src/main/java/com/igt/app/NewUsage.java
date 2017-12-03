package com.igt.app;

import com.igt.AppComponent;
import com.igt.log.LegacyLogger;
import com.igt.log.SiteLogger;
import com.igt.report.LegacyReport;
import dagger.Component;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@Component(modules = {LegacyLogger.class, LegacyReport.class})  // all global singletons has to be listed in @Component annotation (FIXME: Huge class list?)
interface SiteAppComponent extends AppComponent {
    void inject(NewUsage target);
    // all dependant classes has to have corresponding inject method inside @Component interface (FIXME: Huge number of methods?)
}

public class NewUsage {

    @Inject
    LegacyLogger logger;

    @Inject
    LegacyReport report;

    public static void main(String[] args) {
        //TODO: should be part of some global initialization, called only once.
//        SiteAppComponent component = DaggerSiteAppComponent.create();
        SiteAppComponent component = com.igt.app.DaggerSiteAppComponent.builder()   // (FIXME: How to make InteliJ to find this class 'DaggerSiteAppComponent' ?)
                .legacyLogger(new SiteLogger())     // replace module implementation
                .build();

        // create instances of classes and inject them into ObjectGraph to match with dependencies
        NewUsage app = new NewUsage();
        component.inject(app);
        LegacyLogger logger = app.logger;
        System.out.println(logger.getData());

        LegacyReport report = app.report;
        component.inject(report);   // need to inject explicitly! Because it has recursive @Inject (FIXME: How to remember what needs to be injected?)
        System.out.println(report.getReport());

        // old singleton instance also works if injected
        report = LegacyReport.getInstance();
        component.inject(report);
        System.out.println(report.getReport());

    }
}

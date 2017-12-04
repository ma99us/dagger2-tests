package com.igt.app;

import com.igt.AppComponent;
import com.igt.log.LegacyLogger;
import com.igt.log.LogModule;
import com.igt.log.SiteLogModule;
import com.igt.report.LegacyReport;
import com.igt.report.ReportModule;
import dagger.Component;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@Component(modules = {LogModule.class, ReportModule.class})
interface SiteAppComponent extends AppComponent {
    void inject(NewUsage target);
    // all dependant classes has to have corresponding inject method here
}

public class NewUsage {

    AppComponent appComponent;

    @Inject
    LegacyLogger logger;

    @Inject
    LegacyReport report;

    public static void main(String[] args) {
//        SiteAppComponent component = DaggerSiteAppComponent.create();
        SiteAppComponent component = com.igt.app.DaggerSiteAppComponent.builder()
                .logModule(new SiteLogModule())     // replace module implementation
                .build();

//        NewUsage app = new NewUsage();
//        component.inject(app);
//        LegacyLogger logger = app.logger;
//        System.out.println(logger.getData());
//
//        LegacyReport report = app.report;
//        component.inject(report);   // need to inject explicitly! Because it has recursive @Inject
//        System.out.println(report.getReport());

        // old singleton instance also works if injected
        LegacyReport report = LegacyReport.getInstance();
        component.inject(report);
        System.out.println(report.getReport());

    }
}

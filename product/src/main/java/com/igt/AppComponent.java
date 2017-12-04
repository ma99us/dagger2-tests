package com.igt;

import com.igt.log.LegacyLogger;
import com.igt.report.LegacyReport;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {LegacyLogger.class, LegacyReport.class})  // list all singleton modules with @Provides
public interface AppComponent {
    void inject(LegacyReport target);
    //TODO: create methods for all classes with @Inject
}

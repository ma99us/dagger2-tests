package com.igt;

import com.igt.log.LogModule;
import com.igt.report.LegacyReport;
import com.igt.report.ReportModule;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {LogModule.class, ReportModule.class})
public interface AppComponent {
    void inject(LegacyReport target);
}

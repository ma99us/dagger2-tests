package com.igt;

import com.igt.app.NewUsage;
import com.igt.log.LegacyLogger;
import com.igt.report.LegacyReport;
import dagger.Component;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@Component(modules = {LegacyLogger.class, LegacyReport.class})  // all global singletons has to be listed in @Component annotation (FIXME: Huge class list? Can not be inherited from AppComponent?)
public interface SiteAppComponent extends AppComponent {
    void inject(NewUsage target);
    // all dependant classes has to have corresponding inject method inside @Component interface (FIXME: Huge number of methods? At least 'product' methods are inherited.)
}


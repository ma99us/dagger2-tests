package com.igt.log;

import com.sun.istack.internal.NotNull;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

public class SiteLogModule extends LogModule{

    @Override
    public LegacyLogger provideLogger() {
        return new SiteLogger();
    }
}

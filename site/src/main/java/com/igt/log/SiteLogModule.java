package com.igt.log;

public class SiteLogModule extends LogModule{

    @Override
    public LegacyLogger provideLogger() {
        return new SiteLogger();
    }
}

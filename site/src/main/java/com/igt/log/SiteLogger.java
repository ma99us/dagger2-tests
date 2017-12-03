package com.igt.log;

public class SiteLogger extends LegacyLogger {

    @Override
    public LegacyLogger provideLogger() {
        return new SiteLogger();
    }

    @Override
    public String getData() {
        return "- some site data -";
    }
}

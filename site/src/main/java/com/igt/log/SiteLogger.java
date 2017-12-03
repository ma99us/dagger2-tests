package com.igt.log;

public class SiteLogger extends LegacyLogger {

    @Override
    public LegacyLogger provideInstance() {
        return new SiteLogger();
    }

    @Override
    public String getData() {
        return "- some site data -";
    }
}

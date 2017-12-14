package com.igt;


import com.igt.services.SiteIovmService;
import dagger.Component;

import javax.inject.Singleton;

@Component(modules = SiteIovmDaggerModule.class)
@Singleton
public interface SiteIovmComponent extends IovmComponent{
    @Singleton
    SiteIovmService siteIovmService();
}

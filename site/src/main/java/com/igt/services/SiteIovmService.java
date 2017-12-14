package com.igt.services;

import com.igt.SiteIovmComponent;

import javax.inject.Inject;

public class SiteIovmService extends IovmService{

    @Inject
    SiteIovmService() {
        System.out.println("* SiteIovmService");
    }

    public static SiteIovmService getInstance() {
        if(iovmComponent == null){
            iovmComponent = createIovmComponent(com.igt.DaggerSiteIovmComponent.class);
        }
        if(instance == null){
            instance = ((SiteIovmComponent) iovmComponent).siteIovmService();
        }
        System.out.println("= SiteIovmService.getInstance() returns " + instance);
        return (SiteIovmService)instance;
    }
}

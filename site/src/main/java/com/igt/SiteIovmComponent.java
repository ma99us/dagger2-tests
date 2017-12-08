package com.igt;


import dagger.Component;

import javax.inject.Singleton;

@Component(modules = SiteIovmDaggerModule.class)
@Singleton
interface SiteIovmComponent extends IovmComponent{
}

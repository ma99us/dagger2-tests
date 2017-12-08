package com.igt;

import dagger.Component;

import javax.inject.Singleton;

@Component(modules = ProductIovmDaggerModule.class)
@Singleton
public interface ProductIovmComponent extends IovmComponent {
}

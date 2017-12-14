package com.igt;

import com.igt.services.IovmService;

import javax.inject.Singleton;

@Singleton
public interface IovmComponent {
  @Singleton
  IovmService iovmService();
}

package com.igt.services;

import java.util.Set;

public class StatusService {

  private static StatusService instance;

  private StatusService() {

  }

  public static StatusService getInstance() {
    if (instance == null) {
      instance = new StatusService();
    }

    return instance;
  }

  public void printModules() {
    IovmService iovmService = IovmService.getInstance();

    if (iovmService == null) {
      throw new RuntimeException("iovmService is null");
    }

    Set<Class> iovmModulesNames = iovmService.getModulesClasses();

    if (iovmModulesNames == null) {
      throw new RuntimeException("iovmModulesNames is null");
    }

    for(Class moduleName : iovmModulesNames) {
      System.out.println(moduleName);
    }
  }

}

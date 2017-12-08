package com.igt.services;

import com.igt.modules.CashlessIovmModule;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class IovmService {

  private static IovmService instance;

  Map<String, Object> modules;

  private IovmService() {
    modules = new HashMap<String, Object>();

    modules.put("cashlessModule", new CashlessIovmModule());
    modules.put("creditModule", new CashlessIovmModule());
  }

  public static IovmService getInstance() {
    if (instance == null) {
      instance = new IovmService();
    }

    return instance;
  }

  public Set<String> getModulesNames() {
    return modules.keySet();
  }
}

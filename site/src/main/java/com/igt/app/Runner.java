package com.igt.app;

import com.igt.services.IovmService;
import com.igt.services.SiteIovmService;
import com.igt.services.StatusService;

import java.util.Set;

public class Runner {

  public static void main(String[] args) {
    System.out.println("-----------------------------------");
    System.out.println("");

    printModulesDirectlyFromIovmService();

    System.out.println("");
    System.out.println("-----------------------------------");
    System.out.println("");

    printModulesFromStatusService();

    System.out.println("");
    System.out.println("-----------------------------------");
  }

  private static void printModulesDirectlyFromIovmService() {
    SiteIovmService iovmService = SiteIovmService.getInstance();

    if (iovmService == null) {
      throw new RuntimeException("SiteIovmService is null");
    }

    Set<Class> iovmModulesNames = iovmService.getModulesClasses();

    if (iovmModulesNames == null) {
      throw new RuntimeException("iovmModulesNames is null");
    }

    System.out.println("## SiteIovmService modules");
    for(Class moduleName : iovmModulesNames) {
      System.out.println(moduleName);
    }
  }

  private static void printModulesFromStatusService() {
    StatusService statusService = StatusService.getInstance();
    System.out.println("## StatusService modules");
    statusService.printModules();
  }

}

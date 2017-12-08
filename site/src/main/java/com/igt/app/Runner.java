package com.igt.app;

import com.igt.services.IovmService;
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
    IovmService iovmService = IovmService.getInstance();

    if (iovmService == null) {
      throw new RuntimeException("iovmService is null");
    }

    Set<String> iovmModulesNames = iovmService.getModulesNames();

    if (iovmModulesNames == null) {
      throw new RuntimeException("iovmModulesNames is null");
    }

    System.out.println("## IovmService modules");
    for(String moduleName : iovmModulesNames) {
      System.out.println(moduleName);
    }
  }

  private static void printModulesFromStatusService() {
    StatusService statusService = StatusService.getInstance();
    System.out.println("## StatusService modules");
    statusService.printModules();
  }

}

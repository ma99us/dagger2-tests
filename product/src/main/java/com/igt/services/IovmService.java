package com.igt.services;

import com.igt.IovmComponent;
import com.igt.modules.IovmModule;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

@Singleton
public class IovmService {

//  protected static String iovmCmponentClassName = "com.igt.DaggerProductIovmComponent";
  protected static IovmComponent iovmComponent;
  protected static IovmService instance;

  protected static IovmComponent createIovmComponent(Class componentClass) {
    //String componentClassName = System.getProperty("iovmComponentClass", "com.igt.DaggerProductIovmComponent");

    try {
      //Class componentClass = Class.forName(componentClassName);
      Method createMethod = componentClass.getMethod("create");
      return (IovmComponent) createMethod.invoke(null);
//    } catch (ClassNotFoundException e) {
//      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }

    throw new RuntimeException("Could not create Dagger Component for " + componentClass);
  }

  @Inject
  Map<Class, IovmModule> modules;

  @Inject
  IovmService() {
    System.out.println("* IovmService");
  }

  public static IovmService getInstance() {
    if(iovmComponent == null){
      iovmComponent = createIovmComponent(com.igt.DaggerProductIovmComponent.class);
    }
    if(instance == null){
      instance = iovmComponent.iovmService();
    }
    System.out.println("= IovmService.getInstance() returns " + instance);
    return instance;
  }

  public Set<Class> getModulesClasses() {
    return modules.keySet();
  }
}

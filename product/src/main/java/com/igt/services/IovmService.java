package com.igt.services;

import com.igt.DaggerIovmComponent;
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

  private static IovmComponent iovmComponent = createIovmComponent();

  private static IovmComponent createIovmComponent() {
    String componentClassName = System.getProperty("iovmComponentClass", "com.igt.DaggerProductIovmComponent");

    try {
      Class componentClass = Class.forName(componentClassName);
      Method createMethod = componentClass.getMethod("create");
      return (IovmComponent) createMethod.invoke(null);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }

    throw new RuntimeException("Could not create IovmComponent");
  }

  @Inject
  Map<String, IovmModule> modules;

  @Inject
  IovmService() {
  }

  public static IovmService getInstance() {
    return iovmComponent.iovmService();
  }

  public Set<String> getModulesNames() {
    return modules.keySet();
  }
}

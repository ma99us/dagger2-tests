package com.igt;

import com.igt.modules.CashlessIovmModule;
import com.igt.modules.CreditIovmModule;
import com.igt.modules.IovmModule;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;

@Module
public class ProductIovmDaggerModule {

  @Provides @IntoMap
  @ClassKey(CashlessIovmModule.class)
  static IovmModule provideCashlessModule() {
    return new CashlessIovmModule();
  }


  @Provides @IntoMap
  @ClassKey(CreditIovmModule.class)
  static IovmModule provideCreditModule() {
    return new CreditIovmModule();
  }
}

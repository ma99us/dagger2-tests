package com.igt;

import com.igt.modules.CashlessIovmModule;
import com.igt.modules.CreditIovmModule;
import com.igt.modules.IovmModule;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;

@Module
public class ProductIovmDaggerModule {

  @Provides @IntoMap
  @StringKey("cashlessModule")
  static IovmModule provideCashlessModule() {
    return new CashlessIovmModule();
  }


  @Provides @IntoMap
  @StringKey("creditModule")
  static IovmModule provideCreditModule() {
    return new CreditIovmModule();
  }
}

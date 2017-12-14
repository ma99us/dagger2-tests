package com.igt;

import com.igt.modules.CashlessIovmModule;
import com.igt.modules.CreditIovmModule;
import com.igt.modules.IovmModule;
import com.igt.modules.SiteSpecificIovmModule;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;

@Module
public class SiteIovmDaggerModule {

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

  @Provides @IntoMap
  @ClassKey(SiteSpecificIovmModule.class)
  static IovmModule provideSiteSpecificModule() {
    return new SiteSpecificIovmModule();
  }
}

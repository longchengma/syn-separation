package com.home.spring.dependency_injection;

import com.home.spring.dependency_injection.SimpleDaggerDI.NotificationService;
import com.home.spring.dependency_injection.SimpleDaggerDI.Notifier;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class SimpleDaggerDI$Notifier_Factory implements Factory<Notifier> {
  private final Provider<NotificationService> serviceProvider;

  public SimpleDaggerDI$Notifier_Factory(Provider<NotificationService> serviceProvider) {  
    assert serviceProvider != null;
    this.serviceProvider = serviceProvider;
  }

  @Override
  public Notifier get() {  
    return new Notifier(serviceProvider.get());
  }

  public static Factory<Notifier> create(Provider<NotificationService> serviceProvider) {  
    return new SimpleDaggerDI$Notifier_Factory(serviceProvider);
  }
}


package com.pixel.app.di.component;

import com.pixel.app.di.PerService;
import com.pixel.app.di.module.ServiceModule;
import com.pixel.app.service.SyncService;

import dagger.Component;

@PerService
@Component(dependencies = ApplicationComponent.class, modules = ServiceModule.class)
public interface ServiceComponent {

    void inject(SyncService service);

}

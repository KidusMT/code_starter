package com.pixel.app.di.component;

import com.pixel.app.di.module.ApplicationTestModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Provides;


@SuppressWarnings({"unused", "RedundantSuppression"})
@Singleton
@Component(modules = ApplicationTestModule.class)
public interface TestComponent extends ApplicationComponent {
}

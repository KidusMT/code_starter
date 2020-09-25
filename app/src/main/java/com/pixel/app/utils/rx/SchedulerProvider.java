package com.pixel.app.utils.rx;

import io.reactivex.Scheduler;

@SuppressWarnings({"unused", "RedundantSuppression"})
public interface SchedulerProvider {

    Scheduler ui();

    Scheduler computation();

    Scheduler io();

}

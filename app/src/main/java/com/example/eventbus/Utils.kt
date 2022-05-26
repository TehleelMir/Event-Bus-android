package com.example.eventbus

import org.greenrobot.eventbus.EventBus
import java.util.concurrent.TimeUnit
import kotlin.concurrent.thread

object Utils {

    fun triggerEvent() {
        EventBus.getDefault().post(
            DemoModal("First event")
        )

        Thread.sleep(3000)

        EventBus.getDefault().post(
            DemoModal("New Event")
        )
    }
}
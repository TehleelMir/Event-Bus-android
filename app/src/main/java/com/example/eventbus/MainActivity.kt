package com.example.eventbus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        EventBus.getDefault().register(this)
        init()
    }

    private fun init() {
        Utils.triggerEvent()
    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }

    /*
    By default this subscribed method will run in a tread from where it was initially called i.e. posting thread.
    Whether that be a coroutine scope or a main thread or any other background thread it will use the same thread to execute below method.
    But that can be changed by modifying the @Subscribe annotation

    @Subscribe(threadMode = ThreadMode.MAIN)
    will always run on the main thread usually used if the method have to update UI components

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    this will only execute the method on a new background thread, if the method was called on a Main Tread
    otherwise it will use the posting thread.

    @Subscribe(threadMode = ThreadMode.ASYNC)
    this will execute method on a new background thread regardless whether the method was called on a main thread
    or any other thread

    @Subscribe(threadMode = TreadMode.MAIN_ORDERED)
    the TreadMode.Main will make the method a bocking calling, while MAIN_ORDERED won't

    @Subscribe(threadMode = TreadMode.POSTING)
    which is the default value.

    we can also do method overloading to listen for multiple events.
     */
    @Subscribe
    fun listenForTheEventBus(event: DemoModal) {
        Log.i("here22", event.str)
    }
}
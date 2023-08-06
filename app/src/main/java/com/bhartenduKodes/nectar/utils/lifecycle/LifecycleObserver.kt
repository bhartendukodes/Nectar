package com.bhartenduKodes.nectar.utils.lifecycle


import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

class LifecycleObserver : DefaultLifecycleObserver {

    companion object {
        private const val TAG = "CurrentScreen"
    }

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        Log.i(TAG, "OnCreate: ${owner.javaClass.simpleName}")
    }

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        Log.i(TAG, "OnResume: ${owner.javaClass.simpleName}")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        Log.i(TAG, "OnDestroy: ${owner.javaClass.simpleName}")
    }


}

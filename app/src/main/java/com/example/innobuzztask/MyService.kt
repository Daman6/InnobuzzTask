package com.example.innobuzztask

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.AccessibilityServiceInfo
import android.content.pm.PackageManager
import android.util.Log
import android.view.accessibility.AccessibilityEvent
import android.widget.Toast

class MyService : AccessibilityService() {
    override fun onAccessibilityEvent(p0: AccessibilityEvent?) {
        Log.e("main", "event:")
        val packageName: String = p0!!.getPackageName().toString()
        val packageManager = this.packageManager
        try {
            val applicationInfo = packageManager.getApplicationInfo(packageName, 0)
            val applicationLabel = packageManager.getApplicationLabel(applicationInfo)
//            Log.e("main", "app name:$applicationLabel")
//            Log.e("main", "app name:${application.packageName.toString()}")
            Toast.makeText(this, applicationLabel.toString()+" launched", Toast.LENGTH_SHORT).show()
        } catch (e: PackageManager.NameNotFoundException) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    override fun onInterrupt() {
        Log.e("main", "interrupt:")
    }

    override fun onServiceConnected() {
        super.onServiceConnected()
        val info = AccessibilityServiceInfo()
        // pass the typeof events you want your service to listen to
        // other will not be handledby this service
        // pass the typeof events you want your service to listen to
        // other will not be handledby this service
        info.eventTypes = AccessibilityEvent.TYPE_VIEW_CLICKED or
                AccessibilityEvent.TYPE_VIEW_FOCUSED


        // Set the type of feedback your service will provide.
        info.packageNames =
            arrayOf("com.whatsapp")

        // Set the type of feedback your service will provide.
        info.feedbackType = AccessibilityServiceInfo.FEEDBACK_SPOKEN
        // the notification timeout is the time interval after which the service would
        // listen from the system. Anything happening between that interval won't be
        // captured by the service
        // the notification timeout is the time interval after which the service would
        // listen from the system. Anything happening between that interval won't be
        // captured by the service
        info.notificationTimeout = 100

        // finally set the serviceInfo

        // finally set the serviceInfo
        this.serviceInfo = info
        Log.e("main", "onserviceconn:")
    }
}
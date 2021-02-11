package com.edtest.backgroundservicetesting;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.Calendar;

public class TestService extends Service {
    public static final String TAG = "BACKGROUND_SERVICE_TESTING";
    public static final String TAG2 = "TEST_SERVICE: ";
    private static final String CHANNEL_ID = "RUNNING";
    public static final int JOB_ID = 0x151515;

    Context c;

    @Override
    public void onCreate() {
        super.onCreate();

        c = this;

        Notification n = new Notification.Builder(this, CHANNEL_ID)
                .setContentTitle("RUNNING")
                .setContentText("Service Is Running")
                .build();

        startForeground(JOB_ID,n);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.w(TAG, TAG2 + "ON_START_COMMAND");

        //TODO  - do something to show the service is running and doing something??

        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not Yet Implemented");
    }
}

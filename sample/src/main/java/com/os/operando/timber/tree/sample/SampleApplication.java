package com.os.operando.timber.tree.sample;

import android.app.Application;

import com.os.operando.timber.tree.firebasecrashreporting.FirebaseCrashErrorReportTree;
import com.os.operando.timber.tree.firebasecrashreporting.FirebaseCrashLogTree;

import timber.log.Timber;

public class SampleApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Timber.plant(new FirebaseCrashErrorReportTree(), new FirebaseCrashLogTree());
    }
}
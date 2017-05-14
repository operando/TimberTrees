package com.os.operando.timber.tree.sample;

import android.app.Application;

import com.os.operando.timber.tree.crash.slack.CrashReportingSlackTree;
import com.os.operando.timber.tree.firebasecrashreporting.FirebaseCrashErrorReportTree;
import com.os.operando.timber.tree.firebasecrashreporting.FirebaseCrashLogTree;

import timber.log.Timber;

public class SampleApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Timber.plant(new FirebaseCrashErrorReportTree(), new FirebaseCrashLogTree());
        Timber.plant(
                new CrashReportingSlackTree.Builder("your Incoming WebHooks URL for Slack")
                        .channel("android")
                        .iconEmoji(":sushi:")
                        .userName("timber")
                        .build()
        );
    }
}
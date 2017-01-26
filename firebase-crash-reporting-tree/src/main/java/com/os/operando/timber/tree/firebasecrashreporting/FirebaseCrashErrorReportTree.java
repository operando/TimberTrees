package com.os.operando.timber.tree.firebasecrashreporting;

import android.util.Log;

import com.google.firebase.crash.FirebaseCrash;

public class FirebaseCrashErrorReportTree extends LogPriorityTree {

    public FirebaseCrashErrorReportTree() {
        this(Log.ERROR);
    }

    public FirebaseCrashErrorReportTree(int logPriority) {
        super(logPriority);
    }

    @Override
    protected void log(int priority, String tag, String message, Throwable t) {
        if (t != null) {
            FirebaseCrash.report(t);
        }
    }
}
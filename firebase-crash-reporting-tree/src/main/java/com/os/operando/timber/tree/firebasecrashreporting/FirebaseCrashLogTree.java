package com.os.operando.timber.tree.firebasecrashreporting;

import android.util.Log;

import com.google.firebase.crash.FirebaseCrash;

public class FirebaseCrashLogTree extends LogPriorityTree {

    public FirebaseCrashLogTree() {
        this(Log.WARN);
    }

    public FirebaseCrashLogTree(int logPriority) {
        super(logPriority);
    }

    @Override
    protected void log(int priority, String tag, String message, Throwable t) {
        FirebaseCrash.log(message);
    }
}
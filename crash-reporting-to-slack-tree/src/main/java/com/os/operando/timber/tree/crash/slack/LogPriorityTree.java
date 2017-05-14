package com.os.operando.timber.tree.crash.slack;

import timber.log.Timber;

abstract class LogPriorityTree extends Timber.Tree {

    private final int logPriority;

    LogPriorityTree(int logPriority) {
        this.logPriority = logPriority;
    }

    @Override
    protected boolean isLoggable(String tag, int priority) {
        return priority >= logPriority;
    }
}
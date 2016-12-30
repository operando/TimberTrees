# Timber Trees

This library is provides various [timber](https://github.com/JakeWharton/timber) trees.

## Trees

This library provide the following tree.

* [Firebase Crash Reporting](https://firebase.google.com/docs/crash/) Tree

### Firebase Crash Reporting Tree

#### FirebaseCrashErrorReportTree (Default log level: WARN)

Logging to Firebase Crach Rerpoting with `FirebaseCrash.report().`

```java
Timber.plant(new FirebaseCrashErrorReportTree());

or

// Specifying minimum log level
Timber.plant(new FirebaseCrashErrorReportTree(Log.ERROR));
```


#### FirebaseCrashLogTree (Default log level: WARN)

Logging to Firebase Crach Rerpoting with `FirebaseCrash.log().`

```java
Timber.plant(new FirebaseCrashLogTree());

or

// Specifying minimum log level
Timber.plant(new FirebaseCrashLogTree(Log.INFO));
```


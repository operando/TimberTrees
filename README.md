# Timber Trees

This library is provides various [timber](https://github.com/JakeWharton/timber) trees.

## Trees

This library provide the following tree.

* [Firebase Crash Reporting](https://firebase.google.com/docs/crash/) Tree

### Firebase Crash Reporting Tree

#### Download

[![Download](https://api.bintray.com/packages/operandoos/maven/firebase-crash/images/download.svg?version=0.9.0) ](https://bintray.com/operandoos/maven/firebase-crash/0.9.0/link) or grab via Gradle:

```gradle
compile 'com.os.operando.timber.tree:firebase-crash:0.9.0'
```

or Maven:

```
<dependency>
  <groupId>com.os.operando.timber.tree</groupId>
  <artifactId>firebase-crash</artifactId>
  <version>0.9.0</version>
  <type>pom</type>
</dependency>
```

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


### License

```
Apache Version 2.0

Copyright (C) 2016 Shinobu Okano

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

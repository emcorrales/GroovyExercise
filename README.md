This app requires a JRE installed to run.
This app is compatible with JRE 17 to JRE 21 which are stable.
It is not compatible with the latest JRE 22.

You may check the version of JRE by running:
```
java --version
```

Execute the command below to build and run:

For Linux/MacOS
```
./gradlew clean
./gradlew build
./gradlew run
```

For Windows
```
.\gradlew clean
.\gradlew build
.\gradlew run
```


Run it with arguments:

```
./gradlew run ~\sample-files happy sad
```
 or
```
./gradlew run ~\sample-files happy sad ~\sample-files\logs
```

"~\sample-files" is the first argument and is the directory for text files.
"happy" is the second argument and is the text that will be searched
and replaced by the third argument "sad".

The first three arguments are required.

"~\sample-files\logs" is the fourth argument and is optional.
This is where the logs will be written.

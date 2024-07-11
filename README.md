This app requires a JRE installed to run.
This app is compatible with JRE 17 to JRE 21 which are stable.
It is not compatible with the latest JRE 22.

You may check the version of JRE by running:
```
java --version
```


Go to the project root directory and execute the command below to build and run:

For Linux/MacOS:
```
./gradlew clean
./gradlew build
./gradlew run
```

For Windows:
```
.\gradlew clean
.\gradlew build
.\gradlew run
```


Run it with the three ***required*** arguments:

```
./gradlew run ~\sample-files happy sad
```

***~\sample-files*** is the first argument and is the directory for text files.
***happy*** is the second argument and is the text that will be searched
and replaced by the third argument ***sad***.

 or with the ***optional*** fourth argument.
```
./gradlew run ~\sample-files happy sad ~\sample-files\logs
```

***~\sample-files\logs*** is the fourth argument and is a file path to where the logs will be written.

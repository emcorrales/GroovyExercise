This app requires a JRE installed to run.
This app is compatible with JRE 8 to JRE 17

Execute the command below to build and run:

./gradlew clean
./gradlew build
./gradlew run

Run it with arguments:

Example:

./gradlew run ~\sample-files happy sad ~\sample-files\logs

"~\sample-files" is the first argument and is the directory for text files.
"happy" is the second argument and is the text that will be searched
and replaced by the third argument "sad".

The first three arguments are required.

"~\sample-files\logs" is the fourth argument and is optional.
This is where the logs will be written.

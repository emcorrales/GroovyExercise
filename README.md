Note: I did this project on rush due to time constraints for the exam
and short available personal time.
If you looked at this project before July 12 and isn't satisfied,
please consider looking at it again at July 12. Thank you.

This app is compatible with JRE 8 to JRE 17

Execute the command below to build and run:

gradlew clean
gradlew build
gradlew run

Run it with arguments:

Example:

gradlew run ~\sample-files happy sad ~\sample-files\logs

"~\sample-files" is the first argument and is the directory for text files.
"happy" is the second argument and is the text that will be searched
and replaced by the third argument "sad".

The first three arguments are required.

"~\sample-files\logs" is the fourth argument and is optional.
This is where the logs will be written.

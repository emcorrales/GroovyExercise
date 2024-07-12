package com.emcorrales

import groovy.io.FileType
import java.time.LocalDateTime


class GroovyExercise {

    static void main(String[] args) {
        // End program with a message if arguments are invalid.
        if (args.length < 3) {
            println "Invalid arguments. Please enter the following required arguments:"
            println "1. REQUIRED A path to a directory containing some text file."
            println "2. REQUIRED The original text to be replaced."
            println "3. REQUIRED The text that will replace the original"
            println "4. OPTIONAL Path to a file for logging."
            return
        }

        File dir = new File(args[0])
        def oldText = args[1]
        def newText = args[2]

        // Do not proceed if the existing the first argument is not a valid directory.
        if (!dir.isDirectory()) {
            println "Invalid argument. Please enter a directory path as your first argument."
            return
        }

        // Always write logs on the console.
        def consoleLogger = { String message -> println LocalDateTime.now().toString() + "\t" + message }

        // Optional logging on log file.
        def fileLogger = { String logPath, String message ->
            File logFile = new File(logPath)
            logFile.append LocalDateTime.now().toString() + "\t" + message + "\n"
            return message
        }

        // Write logs to the console AND
        // write logs to the logfile if its path as the fourth argument is provided.
        def logger = args.length >= 4 ? fileLogger.curry(args[3]) >> consoleLogger : consoleLogger

        // Find all the txt files inside the directory and its subdirectories.
        try {
            dir.eachFileRecurse(FileType.FILES) {
                if (it.name.endsWith('.txt') && it.text.contains(oldText)) {
                    backupFile(it, logger)
                    replaceAllText(it, oldText, newText, logger)
                }
            }
        } catch (Exception e) {
            logger "Error has occurred:" + e.getMessage()
        }
    }

    // Backup the target file with a new file.
    // The generated name of the backup file would include a timestamp and a '.bak' extension file
    def static backupFile(File file, logger) {
        def timestamp = new Date().getTime()
        def backupFilename = file.absolutePath + timestamp + ".bak"
        logger "Creating backup file " + backupFilename
        def backupFile = new File(backupFilename)
        backupFile.createNewFile()
        backupFile.text = file.text
        logger "Backup file " + backupFilename + " has been created."
    }

    def static replaceAllText(File file, String oldText, newText, logger){
        def update = file.text.replaceAll(oldText) {
            logger "Replacing " + oldText + " with " + newText
            it = newText
        }
        file.text = update
    }
}
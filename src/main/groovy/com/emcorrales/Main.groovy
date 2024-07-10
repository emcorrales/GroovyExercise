package com.emcorrales

import groovy.io.FileType
import java.time.LocalDateTime

static void main(String[] args) {
    // End program with a message if arguments are invalid.
    if (args.length<3) {
        println "Invalid arguments. Please enter the following required arguments:"
        println "1. A path to a directory containing some text file (you can assume that the \n" +
                "directory contains only text files) "
        println "2. The original text or pattern to use for searching in the files (in the given directory \n" +
                "or its subdirectories). "
        println "3. A new text string which will replace the original text or pattern if found in the file \n" +
                "(as many times as it was found). "
        println "4. The class will also allow another optional argument for a path to a file for outputting a \n" +
                "list of which files were modified (logging)."
        return
    }

    File dir = new File(args[0])
    def oldText = args[1]
    def newText = args[2]

    // Do not proceed if the existing the first argument is not a valid directory.
    if(!dir.isDirectory()) {
        println "Invalid argument. Please enter a directory path as your first argument."
        return
    }

    // Always write logs on the console.
    def consoleLogger =  { String message -> println LocalDateTime.now().toString() + "\t" + message }

    // Optional logging on log file.
    def fileLogger = { String message, logger = consoleLogger ->
        logger message
        File logFile = new File(args[3])
        logFile.append LocalDateTime.now().toString() + "\t" + message + "\n"
    }

    // Write logs to file and console if log file path is provided else show logs only on console
    def logger = args.length >= 4? fileLogger:consoleLogger

    // Find all the txt files inside the directory and its subdirectories.
    try {
        dir.eachFileRecurse(FileType.FILES) {
            if(it.name.endsWith('.txt')) {
                def path = it.absolutePath
                logger "Opening " + path

                File out = new File(path)
                def update = out.text.replaceAll(oldText) {
                    logger "Replacing " + it + " with " + newText
                    it = newText
                }

                out.text = update
                logger "Closing " + path
            }
        }
    } catch (Exception e){
        logger e.getMessage()
    }
}
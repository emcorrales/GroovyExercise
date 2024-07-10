package com.emcorrales

import groovy.io.FileType

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

    try {
        dir.eachFileRecurse(FileType.FILES) {
            if(it.name.endsWith('.txt')) {
                println it
                File out = new File(it.absolutePath)
                String line
                it.withReader {
                    while ((line = it.readLine()) != null){
                        def pattern = oldText
                        def match = (line =~ pattern)
                        if(match.find()){
                            def str = match.group()
                            def update = out.text.replaceAll(pattern, newText)
                            println(update)
                            out.text = update
                        }
                    }

                }
            }
        }
    } catch (Exception e){
        println(e.getMessage())
    }
}
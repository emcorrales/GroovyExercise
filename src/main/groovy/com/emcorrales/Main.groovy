package com.emcorrales

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

    def path = args[0]
    validatePath(path)
}

def validatePath(path) {
    // Check if the sourcePath is not null.
    if(path == null){
        println "Invalid argument. The value of sourcePath is null."
        return false
    }

    // Check if first argument is a directory
    File dir = new File(path)
    if(!dir.isDirectory()) {
        println "Invalid argument. Please enter a directory as your first argument."
        return false
    }

    return dir;
}
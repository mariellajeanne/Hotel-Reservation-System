#!/bin/bash

# Compile command
if [ "$1" == "compile" ]; then
    echo "Compiling..."
    errorOccurred=false

    # Ensure the build directory exists
    mkdir -p build

    # Iterate over each Java file in the src directory
    find src -name "*.java" | while read -r filePath; do
        # Extract the relative path for the .java file
        relativePath="${filePath#src/}"
        relativePath="${relativePath%.java}"

        # Extract the directory path from the relative path
        dirPath=$(dirname "$relativePath")

        # Ensure the directory exists in the build directory
        mkdir -p "build/$dirPath"

        # Compile the Java file
        javac -sourcepath src -d build "$filePath"
        if [ $? -ne 0 ]; then
            echo "Compilation failed for $filePath. Please check the error messages above."
            errorOccurred=true
        fi
    done

    if [ "$errorOccurred" == "true" ]; then
        echo "Compilation completed with errors."
        exit 1
    else
        echo "Compilation completed successfully."
    fi

# Run command
elif [ "$1" == "run" ]; then
    echo "Running..."

    # Set classpath to the build directory and execute Main class
    java -cp build Main

    echo "Execution completed."

# Invalid command
else
    echo "ERROR: INVALID ARGUMENT"
    echo "Enter './build.sh compile' to compile the project."
    echo "Enter './build.sh run' to run the project."
    exit 1
fi

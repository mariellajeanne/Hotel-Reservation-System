#!/bin/bash

# Compile command
if [ "$1" == "compile" ]; then
    echo "Compiling..."
    errorOccurred=false
    find ./src -name '*.java' | while read -r file; do
        dir=$(dirname "$file")
        mkdir -p "./build/${dir#./src/}"
        javac -d "./build" "$file"
        if [ $? -ne 0 ]; then
            echo "Compilation failed for '$file'. Please check the error messages above."
            errorOccurred=true
        fi
    done
    if [ "$errorOccurred" = true ]; then
        echo "Compilation completed with errors."
        exit 1
    else
        echo "Compilation completed successfully."
    fi

# Run command
elif [ "$1" == "run" ]; then
    echo "Running..."
    java -cp ./build Main
    echo "Execution completed."

# Invalid command
else
    echo "ERROR: INVALID ARGUMENT"
    echo "Enter './scripts/build.sh compile' to compile the project."
    echo "Enter './scripts/build.sh run' to run the project."
    exit 1
fi

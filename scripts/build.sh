#!/bin/bash

# Ensure that the build directory exists
mkdir -p build

if [ "$1" == "compile" ]; then
    echo "Compiling..."
    errorOccurred=false

    # Find and compile all Java files
    find src -name "*.java" | while read -r file; do
        # Extract the relative path and create the corresponding directory in build
        relativePath="${file#src/}"
        dirName="$(dirname "$relativePath")"
        mkdir -p "build/$dirName"
        
        # Compile the Java file
        javac -sourcepath src -d build "$file"
        if [ $? -ne 0 ]; then
            echo "Compilation failed for $file. Please check the error messages above."
            errorOccurred=true
        fi
    done

    if [ "$errorOccurred" == true ]; then
        echo "Compilation completed with errors."
        exit 1
    else
        echo "Compilation completed successfully."
    fi

elif [ "$1" == "run" ]; then
    echo "Running..."
    
    # Run the Java application
    java -cp build Main

    echo "Execution completed."

else
    echo "ERROR: INVALID ARGUMENT"
    echo "Enter './build.sh compile' to compile the project."
    echo "Enter './build.sh run' to run the project."
    exit 1
fi

#!/bin/bash

# Compile command
compile() {
    echo "Compiling..."
    find ./src -name '*.java' -exec bash -c '
        mkdir -p ./build/$(dirname "{}")
        javac -d ./build "{}"
        if [ $? -ne 0 ]; then
            echo "Compilation failed for {}." >&2
            exit 1
        fi
    ' \;
    if [ $? -ne 0 ]; then
        echo "Compilation failed. Aborting."
        exit 1
    fi
    echo "Compilation completed."
}

# Run command
run() {
    echo "Running..."
    java -cp ./build Main
    echo "Execution completed."
}

# Main script execution based on arguments
case "$1" in
    compile)
        compile
        ;;
    run)
        compile   # Compile first
        run       # Then run
        ;;
    *)
        echo "ERROR: INVALID ARGUMENT"
        echo "Enter \"./scripts/build.sh compile\" to compile the project."
        echo "Enter \"./scripts/build.sh run\" to run the project."
        exit 1
        ;;
esac

exit 0

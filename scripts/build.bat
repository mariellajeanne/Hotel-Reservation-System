@echo off
setlocal enabledelayedexpansion

rem Compile command
if "%1" == "compile" (
    echo Compiling...
    set "errorOccurred=false"

    rem Ensure the build directory exists
    md build 2>nul

    rem Iterate over each Java file in the src directory
    for /r src %%F in (*.java) do (
        rem Extract the relative path for the .java file
        set "filePath=%%~dpF"
        set "relativePath=!filePath:src\=!"
        set "relativePath=!relativePath:~0,-1!"
        
        rem Create the corresponding directory in the build directory
        if not exist build\!relativePath! (
            md build\!relativePath! 2>nul
        )

        rem Compile the Java file
        javac -sourcepath src -d build "%%F"
        if errorlevel 1 (
            echo Compilation failed for "%%F". Please check the error messages above.
            set "errorOccurred=true"
        )
    )
    
    if "%errorOccurred%" == "true" (
        echo Compilation completed with errors.
        endlocal
        exit /b 1
    ) else (
        echo Compilation completed successfully.
        endlocal
    )

rem Run command
) else if "%1" == "run" (
    echo Running...

    rem Set classpath to the build directory and execute Main class
    java -cp build Main

    echo Execution completed.

rem Invalid command
) else (
    echo ERROR: INVALID ARGUMENT
    echo Enter "scripts\build.bat compile" to compile the project.
    echo Enter "scripts\build.bat run" to run the project.
    exit /b 1
)

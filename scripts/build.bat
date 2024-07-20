@echo off

rem Compile command
if "%1" == "compile" (
    echo Compiling...
    setlocal
    set "errorOccurred=false"
    for /r .\src %%F in (*.java) do (
        md ".\build\%%~dpF" 2>nul
        javac -d ".\build" "%%F"
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
    java -cp .\build Main
    echo Execution completed.

rem Invalid command
) else (
    echo ERROR: INVALID ARGUMENT
    echo Enter "./scripts/build.bat compile" to compile the project.
    echo Enter "./scripts/build.bat run" to run the project.
    exit /b 1
)

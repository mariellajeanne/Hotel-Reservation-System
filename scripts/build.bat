@echo off

rem Compile command
if "%1" == "compile" (
    echo Compiling...
    for /r .\src %%F in (*.java) do (
        md ".\build\%%~dpF" 2>nul
        javac -d ".\build" "%%F"
    )
    echo Compilation completed.

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
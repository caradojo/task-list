package com.codurance.training.tasks.command;

public interface CommandParser {
    boolean match(CommandLine commandLine);
    ExecutableCommand parse(CommandLine commandLine);
}

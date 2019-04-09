package com.codurance.training.tasks.command;

public interface CommandParser {
    ExecutableCommand parse(CommandOptionIterator parser);
}

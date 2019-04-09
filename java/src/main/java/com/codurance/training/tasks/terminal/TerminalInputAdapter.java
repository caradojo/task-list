package com.codurance.training.tasks.terminal;

import com.codurance.training.tasks.command.*;

import java.io.BufferedReader;
import java.io.IOException;

public class TerminalInputAdapter {
    private BufferedReader in;
    private CommandLineParser parser;

    public TerminalInputAdapter(BufferedReader in, CommandLineParser parser) {

        this.in = in;
        this.parser = parser;
    }

    public void executeCommand() {
        String commandLine;
        try {
            commandLine = in.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        parser.parse(new CommandLine(commandLine)).execute();
    }
}

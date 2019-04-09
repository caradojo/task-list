package com.codurance.training.tasks.terminal;

import com.codurance.training.tasks.command.*;

import java.io.BufferedReader;
import java.io.IOException;

public class TerminalInputAdapter {
    private BufferedReader in;
    //private CommandLineParser parser;

    public TerminalInputAdapter(BufferedReader in) {

        this.in = in;
    }

    public void executeCommand(CommandSelector commandSelector) {
        String commandLine;
        try {
            commandLine = in.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        CommandLineParser parser = new CommandLineParser(commandLine);

        commandSelector.selectCommand(parser.command).execute(parser);

        // Command command = parser.parse(commandLine);
        //command.execute();

        // commandSelector.selectCommand(parser.command).execute(parser.commandRest);
    }
}

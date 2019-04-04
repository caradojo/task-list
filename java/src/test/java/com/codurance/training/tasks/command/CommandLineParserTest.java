package com.codurance.training.tasks.command;

import org.junit.Assert;
import org.junit.Test;

public class CommandLineParserTest {
    @Test
    public void should_return_the_command()
    {
        CommandLineParser commandLineParser = new CommandLineParser("commandname arg1 arg2 etc...");

        Assert.assertEquals("commandname", commandLineParser.command);
    }

    @Test
    public void should_return_all_args()
    {
        CommandLineParser commandLineParser = new CommandLineParser("commandname arg1 arg2 etc...");

        Assert.assertEquals("arg1 arg2 etc...", commandLineParser.getArgs());
    }

    @Test
    public void should_next_command_line()
    {
        CommandLineParser commandLineParser = new CommandLineParser("commandname arg1 arg2 etc...");

        Assert.assertEquals("arg1", commandLineParser.next().command);
    }
}

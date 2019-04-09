package com.codurance.training.tasks.command;

import org.junit.Assert;
import org.junit.Test;

public class CommandLineTest {
    @Test
    public void should_return_the_command()
    {
        CommandLine commandLineParser = new CommandLine("commandname arg1 arg2 etc...");

        Assert.assertEquals("commandname", commandLineParser.command);
    }

    @Test
    public void should_return_all_args()
    {
        CommandLine commandLineParser = new CommandLine("commandname arg1 arg2 etc...");

        Assert.assertEquals("arg1 arg2 etc...", commandLineParser.getArgs());
    }

    @Test
    public void should_return_first_option()
    {
        CommandLine commandLineParser = new CommandLine("commandname opt1 arg2 etc...");

        Assert.assertEquals("opt1", commandLineParser.option().name);
    }

}

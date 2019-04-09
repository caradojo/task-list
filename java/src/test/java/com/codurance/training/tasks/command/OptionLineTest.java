package com.codurance.training.tasks.command;


import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class OptionLineTest {
    @Test
    public void should_return_the_name_of_the_option()
    {
        OptionLine optionLine = new OptionLine("opt1");

        Assert.assertEquals("opt1", optionLine.name);
    }

    @Test
    public void should_return_the_rest_of_arguments()
    {
        OptionLine optionLine = new OptionLine("opt1 args1 args2 ...");

        Assert.assertEquals("args1 args2 ...", optionLine.getArgs());
    }

}

package com.codurance.training.tasks.command;

class OptionLine {

    private final String[] optionRest;
    final String name;

    OptionLine(String optionLine) {
        optionRest = optionLine.split(" ", 2);
        name = optionRest[0];
    }

    String getArgs() {
        return optionRest[1];
    }

    String[] getArgs(int count) {
        return optionRest[1].split(" ", count);
    }
}

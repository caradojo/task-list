package com.codurance.training.tasks

import java.lang.IllegalArgumentException

class Command {
    enum class Verb {
        SHOW, ADD, CHECK, UNCHECK, HELP, DEADLINE, UNKOWN
    }

    class DealineArgs(val id:String, val date:String)

    public val verb: Command.Verb

    lateinit var dealineArgs: DealineArgs

    constructor(line: String) {
        val commandRest = line.split(" ".toRegex(), 4).toTypedArray()
        val command = commandRest[0]
        this.verb = parseVerb(command);
        if (verb == Verb.DEADLINE){
            dealineArgs = DealineArgs(commandRest[1], commandRest[2])
        }
    }

    private fun parseVerb(command: String): Verb {
        var valueOf: Verb
        try {
            valueOf = Verb.valueOf(command.toUpperCase())
        } catch (e: IllegalArgumentException) {
            valueOf = Verb.UNKOWN
        }
        return valueOf
    }
}

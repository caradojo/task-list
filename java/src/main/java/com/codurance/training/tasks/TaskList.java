package com.codurance.training.tasks;

import com.codurance.training.tasks.command.*;
import com.codurance.training.tasks.terminal.TerminalInputAdapter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.*;

public final class TaskList implements Runnable {
    private final Map<String, List<Task>> tasks = new LinkedHashMap<>();
    private final PrintWriter out;

    private long lastId = 0;
    private boolean exit;
    private TerminalInputAdapter terminalInputAdapter;

    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        new TaskList(in, out).run();
    }

    public TaskList(BufferedReader reader, PrintWriter writer) {
        this.out = writer;

        terminalInputAdapter = new TerminalInputAdapter(
                reader,
                new CommandLineParser(Arrays.asList(
                        new ShowCommand(this),
                        new AddProjectCommand(this),
                        new AddTaskCommand(this),
                        new CheckCommand(this),
                        new UncheckCommand(this),
                        new HelpCommand(this),
                        new QuitCommand(this)),
                        new ErrorCommand(this)));
    }

    public void run() {
        while (!exit) {
            out.print("> ");
            out.flush();
            terminalInputAdapter.executeCommand();
        }
    }

    public void show() {
        for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {
            out.println(project.getKey());
            for (Task task : project.getValue()) {
                out.printf("    [%c] %d: %s%n", (task.isDone() ? 'x' : ' '), task.getId(), task.getDescription());
            }
            out.println();
        }
    }

    public void addProject(String name) {
        tasks.put(name, new ArrayList<>());
    }

    public void quit() {
        exit = true;
    }

    public void addTask(String project, String description) {
        List<Task> projectTasks = tasks.get(project);
        if (projectTasks == null) {
            out.printf("Could not find a project with the name \"%s\".", project);
            out.println();
            return;
        }
        projectTasks.add(new Task(nextId(), description, false));
    }

    public void check(String idString) {
        setDone(idString, true);
    }

    public void uncheck(String idString) {
        setDone(idString, false);
    }

    private void setDone(String idString, boolean done) {
        int id = Integer.parseInt(idString);
        for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {
            for (Task task : project.getValue()) {
                if (task.getId() == id) {
                    task.setDone(done);
                    return;
                }
            }
        }
        out.printf("Could not find a task with an ID of %d.", id);
        out.println();
    }

    public void help() {
        out.println("Commands:");
        out.println("  show");
        out.println("  add project <project name>");
        out.println("  add task <project name> <task description>");
        out.println("  check <task ID>");
        out.println("  uncheck <task ID>");
        out.println();
    }

    public void error(String command) {
        out.printf("I don't know what the command \"%s\" is.", command);
        out.println();
    }

    private long nextId() {
        return ++lastId;
    }
}

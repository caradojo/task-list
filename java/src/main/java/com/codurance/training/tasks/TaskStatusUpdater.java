package com.codurance.training.tasks;

@FunctionalInterface
public interface TaskStatusUpdater {
    Runnable updateStatus(Task task);
}

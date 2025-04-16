package se.lexicon.Dao.Impl;

import se.lexicon.Dao.TodoItemTaskDAO;
import se.lexicon.model.TodoItemTask;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class TodoItemTaskDAOCollection implements TodoItemTaskDAO {
    private final List<TodoItemTask> tasks = new ArrayList<>();

    @Override
    public TodoItemTask persist(TodoItemTask task) {
        if (task == null) {
            throw new IllegalArgumentException("TodoItemTask cannot be null");
        }
        tasks.add(task);
        return task;
    }

    @Override
    public TodoItemTask findById(int id) {
        return tasks.stream()
                .filter(task -> task.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Collection<TodoItemTask> findAll() {
        return new ArrayList<>(tasks);
    }

    @Override
    public Collection<TodoItemTask> findByAssignedStatus(boolean assigned) {
        return tasks.stream()
                .filter(task -> task.isAssigned() == assigned)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<TodoItemTask> findByPersonId(int personId) {
        return tasks.stream()
                .filter(task -> task.getAssignee() != null && task.getAssignee().getId() == personId)
                .collect(Collectors.toList());
    }

    @Override
    public void remove(int id) {
        tasks.removeIf(task -> task.getId() == id);
    }
}

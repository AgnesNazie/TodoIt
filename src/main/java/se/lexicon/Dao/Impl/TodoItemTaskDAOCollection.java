package se.lexicon.Dao.Impl;

import se.lexicon.Dao.TodoItemTaskDAO;
import se.lexicon.model.TodoItemTask;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
    public TodoItemTask findById(Integer id) {
        for (TodoItemTask task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    @Override
    public Collection<TodoItemTask> findAll() {
        return new ArrayList<>(tasks);
    }

    @Override
    public Collection<TodoItemTask> findByAssignedStatus(boolean assigned) {
        List<TodoItemTask> result = new ArrayList<>();
        for (TodoItemTask task : tasks) {
            if (task.isAssigned() == assigned) {
                result.add(task);
            }
        }
        return result;
    }

    @Override
    public Collection<TodoItemTask> findByPersonId(Integer personId) {
        List<TodoItemTask> result = new ArrayList<>();
        for (TodoItemTask task : tasks) {
            if (task.getAssignee() != null && task.getAssignee().getId() == personId) {
                result.add(task);
            }
        }
        return result;
    }

    @Override
    public void remove(Integer id) {
        tasks.removeIf(task -> task.getId() == id);
    }
}

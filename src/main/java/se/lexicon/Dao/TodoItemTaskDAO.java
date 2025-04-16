package se.lexicon.Dao;

import se.lexicon.model.TodoItemTask;

import java.util.Collection;

public interface TodoItemTaskDAO {
    TodoItemTask persist(TodoItemTask task);
    TodoItemTask findById(int id);
    Collection<TodoItemTask> findAll();
    Collection<TodoItemTask> findByAssignedStatus(boolean assigned);
    Collection<TodoItemTask> findByPersonId(int personId);
    void remove(int id);
}

package se.lexicon.Dao.Impl;

import se.lexicon.Dao.TodoItemDAO;
import se.lexicon.model.TodoItem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TodoItemDAOCollection implements TodoItemDAO {
    private final List<TodoItem> items;

    public TodoItemDAOCollection() {
        this.items = new ArrayList<TodoItem>();
    }


    @Override
    public TodoItem persist(TodoItem todoItem) {

        if (todoItem == null) {
            throw new IllegalArgumentException("TodoItem cannot be null");
        }
        items.add(todoItem);
        return todoItem;
    }

    @Override
    public TodoItem findById(Integer id) {
        for (TodoItem item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    @Override
    public Collection<TodoItem> findAll() {
        return new ArrayList<>(items);
    }

    @Override
    public Collection<TodoItem> findAllByDoneStatus(boolean done) {
        List<TodoItem> result = new ArrayList<TodoItem>();
        for (TodoItem item : items) {
            if (item.isDone() == done) {
                result.add(item);
            }
        }
        return result;
    }

    @Override
    public Collection<TodoItem> findByTitleContains(String title) {
        List<TodoItem> result = new ArrayList<TodoItem>();
        if (title == null) {
            return result;
        }
        for (TodoItem item : items) {
            if (item.getTitle() != null && item.getTitle().contains(title)) {
                result.add(item);
            }
        }
        return result;
    }

    @Override
    public Collection<TodoItem> findByPersonId(Integer personId) {
        List<TodoItem> result = new ArrayList<TodoItem>();
        if (personId == null) {
            return result;
        }
        for (TodoItem item : items) {
            if (item.getCreator() != null && personId.equals(item.getCreator().getId())) {
                result.add(item);
            }
        }
        return result;
    }

    @Override
    public Collection<TodoItem> findByDeadlineBefore(LocalDate date) {
        List<TodoItem> result = new ArrayList<TodoItem>();
        if (date == null) {
            return result;
        }
        for (TodoItem item : items) {
            if (item.getDeadline() != null && item.getDeadline().isBefore(date)) {
                result.add(item);
            }
        }
        return result;
    }

    @Override
    public Collection<TodoItem> findByDeadlineAfter(LocalDate date) {
        List<TodoItem> result = new ArrayList<TodoItem>();
        if (date == null) {
            return result;
        }
        for (TodoItem item : items) {
            if (item.getDeadline() != null && item.getDeadline().isAfter(date)) {
                result.add(item);
            }
        }
        return result;
    }

    @Override
    public void remove(Integer id) {
        TodoItem toRemove = null;
        for (TodoItem item : items) {
            if (item.getId() == id) {
                toRemove = item;
                break;
            }
        }
        if (toRemove != null) {
            items.remove(toRemove);
        }
    }
}

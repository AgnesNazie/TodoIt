package se.lexicon.Dao.Test;

import se.lexicon.Dao.Impl.TodoItemTaskDAOCollection;
import se.lexicon.model.AppRole;
import se.lexicon.model.AppUser;
import se.lexicon.model.Person;
import se.lexicon.model.TodoItem;
import se.lexicon.model.TodoItemTask;

import java.time.LocalDate;
import java.util.Collection;

public class TodoItemTaskDAOTest {

    public static void main(String[] args) {
        // Initialize the DAO
        TodoItemTaskDAOCollection dao = new TodoItemTaskDAOCollection();

        // Create a person and a todo item
        AppUser appUser = new AppUser("Agnes_user", "password123", AppRole.ROLE_APP_USER);
        Person person = new Person("Agnes", "Nazie", "Agnes@gmail.com", appUser);
        TodoItem todoItem = new TodoItem("Test Task", "Description", LocalDate.now().plusDays(1), person);

        // Create a TodoItemTask and persist it
        TodoItemTask task = new TodoItemTask(todoItem, person);
        dao.persist(task);

        // Test findById
        TodoItemTask foundTask = dao.findById(task.getId());
        System.out.println("Test findById: " + (foundTask != null && foundTask.getId() == task.getId()));

        // Test findAll
        Collection<TodoItemTask> allTasks = dao.findAll();
        System.out.println("Test findAll: " + (allTasks.size() == 1));

        // Test findByAssignedStatus
        Collection<TodoItemTask> assignedTasks = dao.findByAssignedStatus(true);
        System.out.println("Test findByAssignedStatus: " + (assignedTasks.size() == 1));

        // Test findByPersonId
        Collection<TodoItemTask> personTasks = dao.findByPersonId(person.getId());
        System.out.println("Test findByPersonId: " + (personTasks.size() == 1));

        // Test remove
        dao.remove(task.getId());
        TodoItemTask removedTask = dao.findById(task.getId());
        System.out.println("Test remove: " + (removedTask == null));
    }
}

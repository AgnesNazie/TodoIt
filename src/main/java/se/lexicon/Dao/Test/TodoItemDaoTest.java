package se.lexicon.Dao.Test;

import se.lexicon.Dao.Impl.TodoItemDAOCollection;
import se.lexicon.model.AppRole;
import se.lexicon.model.AppUser;
import se.lexicon.model.Person;
import se.lexicon.model.TodoItem;

import java.time.LocalDate;
import java.util.Collection;

import static se.lexicon.model.AppRole.ROLE_APP_USER;

public class TodoItemDaoTest {
    public static void main(String[] args) {
        TodoItemDAOCollection dao = new TodoItemDAOCollection();

        // Test persist and findById
        TodoItem task1 = new TodoItem("Test Task 1", "Description 1", LocalDate.now().plusDays(1), null);
        dao.persist(task1);
        TodoItem foundTask1 = dao.findById(task1.getId());
        System.out.println("Test persist and findById: " + (foundTask1 != null && foundTask1.getId() == task1.getId()));

        // Test findAll
        Collection<TodoItem> allTasks = dao.findAll();
        System.out.println("Test findAll: " + (allTasks.size() == 1));

        // Test findByDoneStatus
        Collection<TodoItem> doneTasks = dao.findAllByDoneStatus(false);
        System.out.println("Test findByDoneStatus: " + (doneTasks.size() == 1));

        // Test findByTitleContains
        Collection<TodoItem> tasksWithTitle = dao.findByTitleContains("Test");
        System.out.println("Test findByTitleContains: " + (tasksWithTitle.size() == 1));

        // Test findByPersonId
        AppUser appUser = new AppUser("agnes_user", "password123", ROLE_APP_USER);
        Person person = new Person("Agnes", "Nazie","Agnes@gmail.com",appUser );
        TodoItem task2 = new TodoItem("Test Task 2", "Description 2", LocalDate.now().plusDays(2), person);
        dao.persist(task2);
        Collection<TodoItem> personTasks = dao.findByPersonId(person.getId());
        System.out.println("Test findByPersonId: " + (personTasks.size() == 1));

        // Test findByDeadlineBefore
        Collection<TodoItem> overdueTasks = dao.findByDeadlineBefore(LocalDate.now().plusDays(1));
        System.out.println("Test findByDeadlineBefore: " + (overdueTasks.size() == 1));

        // Test findByDeadlineAfter
        Collection<TodoItem> upcomingTasks = dao.findByDeadlineAfter(LocalDate.now());
        System.out.println("Test findByDeadlineAfter: " + (upcomingTasks.size() == 1));

        // Test remove
        dao.remove(task1.getId());
        TodoItem removedTask = dao.findById(task1.getId());
        System.out.println("Test remove: " + (removedTask == null));
    }
}
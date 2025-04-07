package se.lexicon.model;

import java.time.LocalDate;

public class TestTodoItemTask {
    public static void main(String[] args) {
        // create a person object
        Person assignee = new Person("Agnes", "Nazie", "agnes@gmail.com");
        Person creator = new Person("Mehrdad", "Javan", "mehrdad@gmail.com");

        //print person object
        System.out.println("Assignee: " + assignee.getSummary());
        System.out.println("Creator: " + creator.getSummary());
        System.out.println();

        //create  todoItem object
        TodoItem todoItem = new TodoItem("Do Assignment", "Ensure you complete your assignment", LocalDate.now().plusDays(1), creator);

        //print TodoItem  object
        System.out.println("TodoItem: " + todoItem.getSummary());

        //create TodoItemTask object
        TodoItemTask task = new TodoItemTask(todoItem, assignee);

        //print  TodoItem Object
        System.out.println("TodoItemTask: " + task.getSummary());
    }
}


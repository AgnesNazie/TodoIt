package se.lexicon.model;

import java.time.LocalDate;
import java.util.Objects;

public class TodoItem {
    //creates fields
    private static int sequencer = 0;
    private final int id;
    String title;
    String taskDescription;
    LocalDate deadLine;
    boolean done;
    Person creator;

    //constructor
    public TodoItem(String title, String taskDescription, LocalDate deadLine, Person creator) {
        this.id = ++sequencer;
        setTitle(title);
        this.taskDescription = taskDescription;
        setDeadLine(deadLine);
        setCreator(creator);
    }
    // getters for id

    public int getId() {
        return id;
    }
    // getters for title

    public String getTitle() {
        return title;
    }
    // setters for title

    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty())
            throw new IllegalArgumentException("Title cannot be null or empty");
        this.title = title;
    }
    //getters for taskDescription

    public String getTaskDescription() {
        return taskDescription;
    }
    // setters for taskDescription

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }
    //getters for deadline

    public LocalDate getDeadLine() {
        return deadLine;
    }
    //setters for deadline

    public void setDeadLine(LocalDate deadLine) {
        if (deadLine == null || deadLine.isBefore(LocalDate.now()))
            throw new IllegalArgumentException("Deadline cannot be null or in the past");

        this.deadLine = deadLine;
    }
    // set for done

    public void setDone(boolean done) {
        this.done = done;
    }
    // getters for is done

    public boolean isDone() {
        return done;
    }
    // getters for creator

    public Person getCreator() {
        return creator;
    }
    // setters for creator

    public void setCreator(Person creator) {
        if (creator == null)
            throw new IllegalArgumentException("Creator cannot be null");
        this.creator = creator;
    }

    //check if task is overdue
    public boolean isOverdue() {
        return !done && LocalDate.now().isAfter(deadLine);
    }

    // Override toString to represent all fields except Person object(s)
    @Override
    public String toString() {
        return String.format("TodoItem{id=%d, title='%s', description='%s', deadline=%s, done=%b}",
                id, title, taskDescription, deadLine, done);
    }

    // Override equals to compare all fields except the Person object (creator)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        TodoItem todoItem = (TodoItem) obj;
        return done == todoItem.done &&
                id == todoItem.id &&
                Objects.equals(title, todoItem.title) &&
                Objects.equals(taskDescription, todoItem.taskDescription) &&
                Objects.equals(deadLine, todoItem.deadLine);
    }

    // Override hashCode to exclude the Person object (creator)
    @Override
    public int hashCode() {
        return Objects.hash(id, title, taskDescription, deadLine, done);
    }
}

package se.lexicon.model;

import java.time.LocalDate;

public class TodoItem {
    //creates fields
    private static int sequencer = 0;
    private int id;
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

    //get summary method
    public String getSummary() {
        StringBuilder sb = new StringBuilder();
        sb.append("TodoItem: ").append(title)
                .append(", Deadline: ").append(deadLine)
                .append(", Done: ").append(done);
        return sb.toString();
    }
}
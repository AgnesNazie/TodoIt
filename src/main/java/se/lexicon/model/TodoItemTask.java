package se.lexicon.model;

public class TodoItemTask {
    //creates fields

    private static int sequencer = 0;
    private int id;
    private boolean assigned;
    private TodoItem todoItem;
    private Person assignee;

    //constructor

    public TodoItemTask(TodoItem todoItem, Person assignee) {
        this.id = ++sequencer;
        setTodoItem(todoItem);
        setAssignee(assignee);
        this.assigned = assignee != null;
    }
    // getter for id

    public int getId() {
        return id;
    }
    // getter for assigned

    public boolean isAssigned() {
        return assigned;
    }
    //setter for assigned

    public void setAssigned(boolean assigned) {
        this.assigned = assigned;
    }
    // getter for todoItem

    public TodoItem getTodoItem() {
        return todoItem;
    }
    //setter for todoItem

    public void setTodoItem(TodoItem todoItem) {
        if (todoItem == null)
            throw new IllegalArgumentException("TodoItem cannot be null");
        this.todoItem = todoItem;
    }
    //getter for assignee

    public Person getAssignee() {
        return assignee;
    }
    // setter for assignee

    public void setAssignee(Person assignee) {
        this.assignee = assignee;
        this.assigned = (assignee != null);
    }

    // get summary method
    public String getSummary() {
        StringBuilder sb = new StringBuilder();
        sb.append("TodoItemTask {")
                .append("id: ").append(id)
                .append(", Assigned=: ").append(assigned)
                .append(", TodoItem: ").append(todoItem.getSummary())
                .append(", Assignee= ").append(assignee != null ? assignee.getFirstName() + assignee.getLastName() : "None")
                .append('}');
        return sb.toString();
    }
}


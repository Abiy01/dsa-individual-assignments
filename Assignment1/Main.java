//To-Do List Application in Java

package Assignment1;

public class Main {

    public static class Task {
        private String title;
        private String description;
        private boolean completed;

        public Task(String title, String description) {
            this.title = title;
            this.description = description;
            this.completed = false; // Task is not completed initially
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        public boolean isCompleted() {
            return completed;
        }

        public void markCompleted() {
            this.completed = true;
        }
    }

    public static class Node {
        Task task;
        Node next;

        public Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    public static class ToDoList {
        private Node head;

        public ToDoList() {
            this.head = null;
        }

        public void addToDo(Task task) {
            Node newNode = new Node(task);
            if (head == null) {
                head = newNode;
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
        }

        public void markToDoAsCompleted(String title) {
            Node current = head;
            while (current != null) {
                if (current.task.getTitle().equals(title)) {
                    current.task.markCompleted();
                    return;
                }
                current = current.next;
            }
            System.out.println("Task with title: " + title + " not found.");
        }

        public void viewToDoList() {
            Node current = head;
            while (current != null) {
                System.out.println("Title: " + current.task.getTitle());
                System.out.println("Description: " + current.task.getDescription());
                System.out.println("Completed: " + (current.task.isCompleted() ? "Yes" : "No"));
                System.out.println("-----");
                current = current.next;
            }
        }
    }

    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();

        Task task1 = new Task("Buy groceries", "Milk, Bread, Eggs, and Butter");
        Task task2 = new Task("Finish assignment", "Complete the linked list lab");
        Task task3 = new Task("Call mom", "Catch up with mom over the phone");

        toDoList.addToDo(task1);
        toDoList.addToDo(task2);
        toDoList.addToDo(task3);

        System.out.println("Initial To-Do List:");
        toDoList.viewToDoList();

        System.out.println("Marking 'Finish assignment' as completed...");
        toDoList.markToDoAsCompleted("Finish assignment");

        System.out.println("Updated To-Do List:");
        toDoList.viewToDoList();
    }
}

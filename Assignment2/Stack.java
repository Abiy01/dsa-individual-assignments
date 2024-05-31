//Implementation of a Stack Using Linked Lists

package Assignment2;

public class Stack {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node top;

    public Stack() {
        this.top = null;
    }

    // Method to push an element onto the stack
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    // Method to pop an element from the stack
    public int pop() {
        if (top == null) {
            System.out.println("Stack is empty.");
            return -1; // Indicates stack underflow
        }
        int poppedData = top.data;
        top = top.next;
        return poppedData;
    }

    // Method to peek the top element of the stack
    public int peek() {
        if (top == null) {
            System.out.println("Stack is empty.");
            return -1; // Indicates stack underflow
        }
        return top.data;
    }

    // Method to display the stack
    public void displayStack() {
        Node current = top;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Main method for testing
    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Stack after pushes:");
        stack.displayStack();

        int poppedElement = stack.pop();
        System.out.println("Popped element: " + poppedElement);
        System.out.println("Stack after pop:");
        stack.displayStack();

        int topElement = stack.peek();
        System.out.println("Top element: " + topElement);
    }
}


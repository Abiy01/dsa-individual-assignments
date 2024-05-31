//Implementation of Various Operations on LinkedLists

package Assignment2;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    private Node head;

    // Insert a node at a specified position
    public void insertAtPos(int data, int position) {
        Node newNode = new Node(data);
        if (position == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node current = head;
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Position out of bounds");
            return;
        }

        newNode.next = current.next;
        current.next = newNode;
    }

    // Delete a node at a specified position
    public void deleteAtPosition(int position) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (position == 1) {
            head = head.next;
            return;
        }

        Node current = head;
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null || current.next == null) {
            System.out.println("Position out of bounds");
            return;
        }

        current.next = current.next.next;
    }

    // Delete a node after a given node
    public void deleteAfterNode(Node givenNode) {
        if (givenNode == null || givenNode.next == null) {
            System.out.println("No node to delete after the given node");
            return;
        }

        givenNode.next = givenNode.next.next;
    }

    // Search for a node with a specific value
    public boolean searchNode(int value) {
        Node current = head;
        while (current != null) {
            if (current.data == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Display the linked list
    public void displayList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Main method to run the LinkedList class
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        System.out.println("Inserting nodes at specified positions:");
        list.insertAtPos(10, 1);
        list.insertAtPos(20, 2);
        list.insertAtPos(30, 3);
        list.insertAtPos(15, 2);
        list.displayList();

        System.out.println("Deleting node at position 3:");
        list.deleteAtPosition(3);
        list.displayList();

        System.out.println("Deleting node after the first node:");
        list.deleteAfterNode(list.head);
        list.displayList();

        System.out.println("Searching for node with value 20:");
        System.out.println(list.searchNode(20) ? "Node found" : "Node not found");

        System.out.println("Searching for node with value 100:");
        System.out.println(list.searchNode(100) ? "Node found" : "Node not found");
    }
}


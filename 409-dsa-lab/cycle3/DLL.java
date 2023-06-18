import java.util.Scanner;

class Node {
    int data;
    Node prev;
    Node next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    private Node head;
    private Node tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insertAtFront(int data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        System.out.println("Inserted " + data + " at the front.");
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        System.out.println("Inserted " + data + " at the end.");
    }

    public void deleteFromFront() {
        if (isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }

        int data = head.data;

        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }

        System.out.println("Deleted " + data + " from the front.");
    }

    public void deleteFromEnd() {
        if (isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }

        int data = tail.data;

        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }

        System.out.println("Deleted " + data + " from the end.");
    }

    public void displayForward() {
        if (isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }

        System.out.println("List elements (forward):");
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void displayBackward() {
        if (isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }

        System.out.println("List elements (backward):");
        Node current = tail;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }
}

public class DLL {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 7) {
            System.out.println("Doubly Linked List Menu:");
            System.out.println("1. Insert at the front");
            System.out.println("2. Insert at the end");
            System.out.println("3. Delete from the front");
            System.out.println("4. Delete from the end");
            System.out.println("5. Display list (forward)");
            System.out.println("6. Display list (backward)");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to insert at the front: ");
                    int elementToFront = scanner.nextInt();
                    list.insertAtFront(elementToFront);
                    break;
                case 2:
                    System.out.print("Enter the element to insert at the end: ");
                    int elementToEnd = scanner.nextInt();
                    list.insertAtEnd(elementToEnd);
                    break;
                case 3:
                    list.deleteFromFront();
                    break;
                case 4:
                    list.deleteFromEnd();
                    break;
                case 5:
                    list.displayForward();
                    break;
                case 6:
                    list.displayBackward();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            System.out.println();
        }

        scanner.close();
    }
}

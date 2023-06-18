import java.util.Scanner;

class Node {
    int coefficient;
    int exponent;
    Node next;

    public Node(int coefficient, int exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
        this.next = null;
    }
}

class Polynomial {
    private Node head;

    public Polynomial() {
        this.head = null;
    }

    public void insertTerm(int coefficient, int exponent) {
        Node newNode = new Node(coefficient, exponent);

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

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.coefficient + "x^" + current.exponent);
            current = current.next;
            if (current != null) {
                System.out.print(" + ");
            }
        }
        System.out.println();
    }

    public Polynomial add(Polynomial p) {
        Polynomial result = new Polynomial();
        Node currentA = this.head;
        Node currentB = p.head;

        while (currentA != null && currentB != null) {
            if (currentA.exponent > currentB.exponent) {
                result.insertTerm(currentA.coefficient, currentA.exponent);
                currentA = currentA.next;
            } else if (currentA.exponent < currentB.exponent) {
                result.insertTerm(currentB.coefficient, currentB.exponent);
                currentB = currentB.next;
            } else {
                int sum = currentA.coefficient + currentB.coefficient;
                if (sum != 0) {
                    result.insertTerm(sum, currentA.exponent);
                }
                currentA = currentA.next;
                currentB = currentB.next;
            }
        }

        while (currentA != null) {
            result.insertTerm(currentA.coefficient, currentA.exponent);
            currentA = currentA.next;
        }

        while (currentB != null) {
            result.insertTerm(currentB.coefficient, currentB.exponent);
            currentB = currentB.next;
        }

        return result;
    }
}

public class AddPoly {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial();

        System.out.println("Polynomial Addition");
        System.out.println("-------------------");

        System.out.println("Enter Polynomial 1:");
        readPolynomial(scanner, p1);

        System.out.println("Enter Polynomial 2:");
        readPolynomial(scanner, p2);

        Polynomial sum = p1.add(p2);

        System.out.println("\nPolynomial 1:");
        p1.display();
        System.out.println("Polynomial 2:");
        p2.display();
        System.out.println("Sum:");
        sum.display();
    }

    private static void readPolynomial(Scanner scanner, Polynomial polynomial) {
        System.out.print("Enter the number of terms: ");
        int numTerms = scanner.nextInt();

        for (int i = 1; i <= numTerms; i++) {
            System.out.println("Term " + i + ":");
            System.out.print("Coefficient: ");
            int coefficient = scanner.nextInt();
            System.out.print("Exponent: ");
            int exponent = scanner.nextInt();

            polynomial.insertTerm(coefficient, exponent);
        }
    }
}

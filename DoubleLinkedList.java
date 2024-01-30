public class DoubleLinkedList {

  Node head;
  Node tail;

  // Constructor de la lista doblemente enlazada
  public DoubleLinkedList() {
    this.head = null;
    this.tail = null;
  }

  // Método para agregar un nodo al inicio de la lista
  public void addFirst(int x, int y) {
    Node newNode = new Node(x, y);

    if (head == null) {
      head = tail = newNode;
    } else {
      newNode.next = head;
      head.prev = newNode;
      head = newNode;
    }
  }

  // Método para agregar un nodo al final de la lista
  public void addLast(int x, int y) {
    Node newNode = new Node(x, y);

    if (head == null) {
      head = tail = newNode;
    } else {
      newNode.prev = tail;
      tail.next = newNode;
      tail = newNode;
    }
  }

  // Método para borrar todos los nodos con valores dados
  public void delete(Node n) {
    int x = n.x;
    int y = n.y;
    Node actual = head;

    while (actual != null) {
      if (actual.x == x && actual.y == y) {
        if (actual.prev != null) {
          actual.prev.next = actual.next;
        } else {
          head = actual.next;
        }

        if (actual.next != null) {
          actual.next.prev = actual.prev;
        } else {
          tail = actual.prev;
        }
      }

      actual = actual.next;
    }
  }

  // Método para imprimir la lista
  public void printList() {
    Node actual = head;

    System.out.println("Elementos de la lista:");

    while (actual != null) {
      System.out.println("(" + actual.x + ", " + actual.y + ")");
      actual = actual.next;
    }

    System.out.println();
  }

  public static void main(String[] args) {
    DoubleLinkedList lista = new DoubleLinkedList();

    lista.addFirst(1, 2);
    lista.addFirst(3, 4);
    lista.addLast(5, 6);
    lista.addLast(7, 8);
    lista.addFirst(1, 2);

    System.out.println("Lista original:");
    lista.printList();

    lista.delete(lista.head);

    System.out.println("Lista después de borrar nodos (1, 2):");
    lista.printList();
  }
}

class Node {
  int x;
  int y;
  Node next;
  Node prev;

  public Node(int x, int y) {
    this.x = x;
    this.y = y;
    this.next = null;
    this.prev = null;
  }
}
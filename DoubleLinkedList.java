public class DoubleLinkedList {

  Node head;
  Node tail;

  public DoubleLinkedList() {
    this.head = null;
    this.tail = null;
  }

  public void addFirst(int x, int y) {
    Node newNode = new Node(x, y);

    if (head == null)
      head = tail = newNode;
    else {
      newNode.next = head;
      head.prev = newNode;
      head = newNode;
    }
  }

  public void addLast(int x, int y) {
    Node newNode = new Node(x, y);

    if (head == null)
      head = tail = newNode;
    else {
      newNode.prev = tail;
      tail.next = newNode;
      tail = newNode;
    }
  }

  public void delete(Node n) {
    int x = n.x;
    int y = n.y;
    Node actual = head;

    while (actual != null) {
      if (actual.x == x && actual.y == y) {
        if (actual.prev != null)
          actual.prev.next = actual.next;
        else
          head = actual.next;

        if (actual.next != null)
          actual.next.prev = actual.prev;
        else
          tail = actual.prev;

      }

      actual = actual.next;
    }
  }

  public void printList() {
    Node actual = head;

    System.out.println("Elementos de la lista:");

    while (actual != null) {
      System.out.println("(" + actual.x + ", " + actual.y + ")");
      actual = actual.next;
    }

    System.out.println();
  }
}
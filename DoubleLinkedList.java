public class DoubleLinkedList {

  Node head;
  Node tail;

  public DoubleLinkedList() {
    this.head = null;
    this.tail = null;
  }

  public void addFirst(int x, int y) {
    /* if (isIn(x, y))// the node is already in the list
      return; */ //check what difference it makes

    Node newNode = new Node(x, y);

    if (head == null)
      head = tail = newNode;
    else {
      newNode.next = head;
      head.prev = newNode;
      head = newNode;
    }
  }

  public boolean isIn(int x, int y) {
    Node current = head;
    while (current != null) {
      if (current.x == x && current.y == y)
        return true;
      current = current.next;
    }
    return false;
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
        /* return; */
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
package alldatastructure.linked.list.doubly.co;

class Main {
  public static void main(String[] args) {
    DoublyLinkedList dll = new DoublyLinkedList();
    dll.createDLL(1);
    dll.insertDLL(3, 1);
    dll.deleteNodeDLL(1);
    dll.traverseDLL();

    dll.insertDLL(4, 7);
    dll.traverseDLL();
    dll.deleteDLL();
    dll.traverseDLL();
  }
}

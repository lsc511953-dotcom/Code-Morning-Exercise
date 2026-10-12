public class Test {
    public static void main(String[] args) {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.addLast(12);
        linkedList.addLast(16);
        linkedList.addLast(14);
        linkedList.addLast(13);

        linkedList.display();

        linkedList.addFirst(3);
        linkedList.addFirst(4);
        linkedList.addFirst(5);
        linkedList.addFirst(6);

        linkedList.display();

        linkedList.add(3,2);

        linkedList.display();

        System.out.println(linkedList.size());

        System.out.println(linkedList.contains(1));

        linkedList.remove(4);
        linkedList.display();

        linkedList.clear();

        linkedList.display();

        linkedList.addLast(1);
        linkedList.addLast(3);
        linkedList.addLast(1);
        linkedList.addLast(5);
        linkedList.addLast(1);

        linkedList.removeAllKeys(1);

        linkedList.display();
    }
}

public class MyStack<E> {
    private static class ListNode<E>{
        E val;
        ListNode<E> prev;
        ListNode<E> next;

        public ListNode(E val) {
            this.val = val;
        }
    }
    private ListNode<E> head;
    private ListNode<E> last;

    public E push(E e) {
        ListNode<E> node = new ListNode<>(e);
        if(this.head == null) {
            this.head = node;
            this.last = node;
            return e;
        }
        this.last.next = node;
        node.prev = this.last;
        this.last = node;
        return e;
    }

    public E pop() {
        if(isEmpty()) {
            throw new EmptyStackException("空栈异常");
        }
        E val = this.last.val;
        this.last = this.last.prev;
        if(this.last == null) {
            this.head = null;
        }else{
            this.last.next = null;
        }
        return val;
    }

    public E peek() {
        if(isEmpty()) {
            throw new EmptyStackException("空栈异常");
        }
        return this.last.val;
    }

    public int size() {
        ListNode<E> cur = this.head;
        int count = 0;
        while(cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    public boolean isEmpty() {
        return this.head == null;
    }
}

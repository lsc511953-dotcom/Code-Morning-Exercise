public class MyStack <E>{
    private static class ListNode<E> {
        E val;
        ListNode<E> prev;
        ListNode<E> next;

        public ListNode(E val) {
            this.val = val;
        }
    }
    private ListNode<E> head;
    private ListNode<E> last;

    //入栈(尾插)
    public E push(E e) {
        ListNode<E> node = new ListNode<>(e);
        if(this.head == null) {
            this.last = node;
            this.head = node;
            return e;
        }
        this.last.next = node;
        node.prev = this.last;
        this.last = node;
        return e;
    }


    //出栈(尾出)
    public E pop() {
        if(isEmpty()) {
            throw new StackEmptyException("栈空异常");
        }
        E oldVal = this.last.val;
        this.last = this.last.prev;
        if(this.last == null) {
            this.head = null;
            return oldVal;
        }
        this.last.next = null;
        return oldVal;
    }

    private boolean isEmpty() {
        return this.head == null;
    }

    //查看栈顶元素
    public E peek() {
        if(isEmpty()) {
            throw new StackEmptyException("栈空异常");
        }
        return this.last.val;
    }

    //获取栈内元素
    public int size() {
        ListNode<E> cur = this.head;
        int count = 0;
        while(cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }
}

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

    //入栈
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

    //出栈
    public E pop() {
        if(isEmpty()) {
            return null;
        }
        E oldVal = this.last.val;
        this.last = this.last.prev;
        if(this.last == null) {
            this.head = null;
        }else {
            this.last.next = null;
        }
        return oldVal;
    }

    //查看栈顶元素
    public E peek() {
        if(isEmpty()) {
            return null;
        }
        return this.last.val;
    }

    //获取栈内元素个数
    public int size() {
        ListNode<E> cur = this.head;
        int count = 0;
        while(cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    //判断栈是否为空
    public boolean isEmpty() {
        return this.head == null;
    }
}

import java.util.List;

public class MyStack<E>{
    private static class ListNode<T>{
        T val;
        ListNode<T> prev;
        ListNode<T> next;
        public ListNode(T val) {
            this.val = val;
        }
    }
    private ListNode<E> head;
    private ListNode<E> last;

    //入栈(尾插)
    public E push(E val) {
        ListNode<E> node = new ListNode<>(val);
        if(this.head == null) {
            this.head = node;
            this.last = node;
            return node.val;
        }
        this.last.next = node;
        node.prev = this.last;
        this.last = node;
        return node.val;
    }

    //出栈(尾出)
    public E pop() {
        if(isEmpty()) {
            throw new EmptyStackException("栈为空");
        }
        E oldVal = this.last.val;
        this.last = this.last.prev;
        if(this.last == null) {
            this.head = null;
        }else{
            this.last.next = null;
        }
        return oldVal;
    }

    //查看栈顶元素
    public E peek() {
        if(isEmpty()) {
            throw new EmptyStackException("栈为空");
        }
        return this.last.val;
    }

    //获取栈元素个数
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

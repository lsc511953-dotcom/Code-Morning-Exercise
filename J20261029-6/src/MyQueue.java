/**
 * 基于双向链表实现队列
 * @param <E>
 */
public class MyQueue <E>{
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

    //入队
    public boolean offer(E e) {
        ListNode<E> node = new ListNode<>(e);
        if(this.head == null) {
            this.last = node;
            this.head = node;
            return true;
        }
        this.last.next = node;
        node.prev = this.last;
        this.last = node;
        return true;
    }

    //出队
    public E poll() {
        if(isEmpty()) {
            return null;
        }
        E oldVal = this.head.val;
        this.head = this.head.next;
        if(this.head == null) {
            this.last = null;
        }else{
            this.head.prev = null;
        }
        return oldVal;
    }

    //查看队首元素
    public E peek() {
        if(isEmpty()) {
            return null;
        }
        return this.head.val;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return this.head == null;
    }

    //获取队列元素个数
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

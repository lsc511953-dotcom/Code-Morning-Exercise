/**
 * 基于数组实现队列(牺牲一个空间)
 * @param <E>
 */
public class MyQueue1<E> {
    private Object[] elem;
    private int head;
    private int last;
    private final int capacity;

    public MyQueue1(int k) {
        if(k <= 0) {
            throw new IllegalArgumentException("初始容量必须大于0");
        }
        capacity = k + 1;
        elem = new Object[capacity];
    }

    /**
     * 入队(尾插)
     * @param e
     * @return true，表示入队成功；false，表示队列已满
     */
    public boolean offer(E e) {
        if(isFull()) {
            return false;
        }
        elem[last] = e;
        this.last = (this.last + 1) % capacity;
        return true;
    }

    private boolean isFull() {
        return (this.last + 1) % capacity == this.head;
    }

    /**
     * 出队(首出)
     * @return 返回队首元素
     */
    @SuppressWarnings("unchecked")
    public E poll() {
        if(isEmpty()) {
            return null;
        }
        E oldVal = (E)elem[head];
        elem[head] = null;
        this.head = (this.head + 1) % capacity;
        return oldVal;
    }

    /**
     * 查看队首元素
     * @return 返回队首元素
     */
    @SuppressWarnings("unchecked")
    public E peek() {
        if(isEmpty()) {
            return null;
        }
        return (E)elem[head];
    }

    /**
     * 判断队列是否为空
     * @return true，表示队列为空；false，表示队列不为空
     */
    public boolean isEmpty() {
        return this.head == this.last;
    }

    /**
     * 查看队列元素个数
     * @return 返回队列元素个数
     */
    public int size() {
        if(this.last >= this.head) {
            return this.last - this.head;
        }else{
            return this.last + (this.capacity - this.head);
        }
    }

}

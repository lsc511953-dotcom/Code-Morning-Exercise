/**
 * 基于数组实现队列(标志位法)
 * @param <E>
 */
public class MyQueue3<E> {
    private Object[] elem;
    private boolean isFull;
    private int head;
    private int last;
    private final int capacity;

    public MyQueue3(int k) {
        if(k <= 0) {
            throw new IllegalArgumentException("初始容量必须大于0");
        }
        capacity = k;
        elem = new Object[capacity];
    }

    /**
     * 入队(尾插)
     * @param e
     * @return 返回true,入队成功,返回false队列已满
     */
    public boolean offer(E e) {
        if(isFull()) {
            return false;
        }
        elem[last] = e;
        this.last = (this.last + 1) % capacity;
        if(this.last == this.head) {
            isFull = true;
        }
        return true;
    }

    private boolean isFull() {
        return isFull;
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
        this.isFull = false;
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
     * @return true,队列为空,false,队列不为空
     */
    public boolean isEmpty() {
        return this.head == this.last && !isFull;
    }

    /**
     * 获取队列元素个数
     * @return 返回队列元素个数
     */
    public int size() {
        if(isFull()) {
            return capacity;
        }
        if(this.last >= this.head) {
            return this.last - this.head;
        }else{
            return this.last + (this.capacity - this.head);
        }
    }
}

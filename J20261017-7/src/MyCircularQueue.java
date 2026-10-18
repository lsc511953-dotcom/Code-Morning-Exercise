import java.util.MissingFormatArgumentException;

/**
 * 基于数组实现队列(循环队列)
 * 方法一:牺牲一个空间
 * @param <E>
 */
public class MyCircularQueue<E>{
    private Object[] elem;
    private int head;
    private int last;
    private final int capacity;

    public MyCircularQueue(int k) {
        if(k <= 0) {
            throw new IllegalArgumentException("初始容量必须大于0");
        }
        capacity = k + 1;
        elem = new Object[capacity];
    }

    //入队(尾插)
    public boolean offer(E e) {
        if(isFull()) {
            return false;
        }
        elem[last] = e;
        last = (last + 1) % capacity;
        return true;
    }

    private boolean isFull() {
        return (this.last + 1) % capacity == head;
    }

    @SuppressWarnings("unchecked")
    //出队(头出)
    public E poll() {
        if(isEmpty()) {
            return null;
        }
        E oldVal = (E)elem[head];
        elem[head] = null;
        this.head = (this.head + 1) % capacity;
        return oldVal;
    }

    @SuppressWarnings("unchecked")
    //查看队首元素
    public E peek() {
        if(isEmpty()) {
            return null;
        }
        return (E)elem[head];
    }

    //获取队列元素个数
    public int size() {
        if(this.head <= this.last) {
            return this.last - this.head;
        }else{
            return this.last + (this.capacity - this.head);
        }
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return this.head == this.last;
    }
}

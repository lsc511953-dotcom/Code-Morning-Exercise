public class MyQueue2<E> {
    private Object[] elem;
    private int size;
    private int head;
    private int last;
    private final int capacity;

    public MyQueue2(int k) {
        if(k <= 0) {
            throw new IllegalArgumentException("初始容量必须大于0");
        }
        capacity = k;
        elem = new Object[capacity];
    }

    //入队
    public boolean offer(E e) {
        if(isFull()) {
            return false;
        }
        elem[last] = e;
        size++;
        this.last = (this.last + 1) % capacity;
        return true;
    }

    //判满
    public boolean isFull() {
        return size == elem.length;
    }

    //出队
    @SuppressWarnings("unchecked")
    public E poll() {
        if(isEmpty()) {
            return null;
        }
        E oldVal = (E)elem[head];
        elem[head] = null;
        size--;
        this.head = (this.head + 1) % capacity;
        return oldVal;
    }

    //判空
    public boolean isEmpty() {
        return size == 0;
    }

    //查看队首元素
    @SuppressWarnings("unchecked")
    public E peek() {
        if(isEmpty()) {
            return null;
        }
        return (E)elem[head];
    }

    //获取队列元素个数
    public int size() {
        return size;
    }
}

public class MyCircularQueue2<E>{
    private Object[] elem;
    private int head;
    private int last;
    private int size;
    private final int capacity;

    public MyCircularQueue2(int k) {
        if(k <= 0) {
            throw new IllegalArgumentException("初始容量必须大于0");
        }
        capacity = k;
        elem = new Object[capacity];
    }

    //入队(尾插)
    public boolean offer(E e) {
        if(isFull()) {
            return false;
        }
        elem[last] = e;
        size++;
        this.last = (this.last + 1) % capacity;
        return true;
    }

    private boolean isFull() {
        return this.size == this.elem.length;
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

    //判断队列是否为空
    public boolean isEmpty() {
        return size == 0;
    }
}

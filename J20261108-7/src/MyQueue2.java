/**
 * 基于数组实现队列(使用size属性)
 * @param <E>
 */
public class MyQueue2<E>{
    private Object[] elem;
    private int size;//有效元素个数
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
        this.size++;
        return true;
    }

    private boolean isFull() {
        return this.size == this.elem.length;
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
        this.size--;
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
        return this.size == 0;
    }

    /**
     * 获取队列元素个数
     * @return 返回队列元素个数
     */
    public int size() {
        return this.size;
    }
}

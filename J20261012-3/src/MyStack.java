import java.util.Arrays;

/**
 * 基于数组模拟实现栈
 * @param <E>
 */
public class MyStack<E> {
    private Object[] elem;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyStack() {
        elem = new Object[DEFAULT_CAPACITY];
    }

    public MyStack(int initialCapacity) {
        if(initialCapacity <= 0) {
            throw new IllegalArgumentException("初始容量必须大于0");
        }
        elem = new Object[initialCapacity];
    }

    /**
     * LIFO(尾插)
     * @param e
     * @return
     */
    public E push(E e) {
        if(isFull()) {
            elem = Arrays.copyOf(elem,2 * elem.length);
        }
        elem[size] = e;
        this.size++;
        return e;
    }

    private boolean isFull() {
        return this.size == elem.length;
    }

    public E pop() {
        if(isEmpty()) {
            throw new EmptyStackException("空栈异常");
        }
        E oldVal = (E)elem[size - 1];
        elem[size - 1] = null;
        this.size--;
        return oldVal;
    }

    public E peek() {
        if(isEmpty()) {
            throw new EmptyStackException("空栈异常");
        }
        return (E)elem[size - 1];
    }

    private boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return size;
    }
}

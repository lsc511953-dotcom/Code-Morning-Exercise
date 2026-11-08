import java.util.Arrays;

/**
 * @author lSC
 * @version 1.0
 * 基于数组模拟实现栈
 * @param <E>
 */
public class MyStack<E> {
    private Object[] elem;
    private int size;//有效元素个数
    private static final int DEFAULT_CAPACITY = 10;

    //默认构造方法
    public MyStack() {
        elem = new Object[DEFAULT_CAPACITY];
    }

    //指定容量的构造方法
    public MyStack(int initialCapacity) {
        if(initialCapacity <= 0) {
            throw new IllegalArgumentException("初始容量必须大于0");
        }
        elem = new Object[initialCapacity];
    }

    /**
     * 入栈(尾插)
     * @param e
     * @return
     */
    public E push(E e) {
        if(isFull()) {
            grow();
        }
        elem[size] = e;
        this.size++;
        return e;
    }

    private boolean isFull() {
        return this.size == this.elem.length;
    }

    private void grow() {
        elem = Arrays.copyOf(elem,2 * elem.length);
    }

    /**
     * 出栈(尾出)
     * @return
     */
    @SuppressWarnings("unchecked")
    public E pop() {
        if(isEmpty()) {
            throw new StackEmptyException("栈空异常");
        }
        E oldVal = (E)elem[size - 1];
        elem[size - 1] = null;
        this.size--;
        return oldVal;
    }

    /**
     * 查看栈顶元素
     * @return
     */
    @SuppressWarnings("unchecked")
    public E peek() {
        if(isEmpty()) {
            throw new StackEmptyException("栈空异常");
        }
        return (E)elem[size - 1];
    }

    /**
     * 判断栈是否为空
     * @return
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * 获取栈内元素个数
     * @return
     */
    public int size() {
        return size;
    }
}

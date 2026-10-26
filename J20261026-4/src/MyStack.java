import java.util.Arrays;


public class MyStack<E> {
    private Object[] elem;
    private int size;
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

    //入栈
    public E push(E e) {
        if(isFull()) {
            elem = Arrays.copyOf(elem,2 * elem.length);
        }
        elem[size] = e;
        this.size++;
        return e;
    }

    private boolean isFull() {
        return size == elem.length;
    }

    @SuppressWarnings("unchecked")
    //出栈
    public E pop() {
        if(isEmpty()) {
            throw new EmptyStackException("栈空异常");
        }
        E oldVal = (E)elem[size - 1];
        elem[size - 1] = null;
        size--;
        return oldVal;
    }

    //判断是否为空
    public boolean isEmpty() {
        return this.size == 0;
    }

    @SuppressWarnings("unchecked")
    //查看栈顶元素
    public E peek() {
        if(isEmpty()) {
            throw new EmptyStackException("栈空异常");
        }
        return (E)elem[size - 1];
    }

    //获取栈内元素个数
    public int size() {
        return size;
    }
}

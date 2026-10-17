import java.util.Arrays;

//基于数组实现栈
public class MyStack<E>{
    private Object[] elem;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    //无参构造方法
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
    public E push(E val) {
        if(isFull()) {
            elem = Arrays.copyOf(elem,2 * elem.length);
        }
        elem[size] = val;
        size++;
        return val;
    }

    //判断栈满方法
    private boolean isFull() {
        return this.size == this.elem.length;
    }

    //出栈
    @SuppressWarnings("unchecked")
    public E pop() {
        if(isEmpty()) {
            throw new EmptyStackException("栈为空");
        }
        E oldVal = (E)elem[size - 1];
        elem[size - 1] = null;
        size--;
        return oldVal;
    }

    //查看栈元素个数
    public int size() {
        return size;
    }

    //查看栈顶元素
    @SuppressWarnings("unchecked")
    public E peek() {
        if(isEmpty()) {
            throw new EmptyStackException("栈为空");
        }
        return (E)elem[size - 1];
    }

    //判断栈是否为空
    public boolean isEmpty() {
        return size == 0;
    }
}

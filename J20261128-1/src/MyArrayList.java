import java.util.Arrays;
import java.util.Objects;

public class MyArrayList<E> implements IList<E>{
    private Object[] elem;
    private int size;//有效元素个数
    private static final int DEFAULT_CAPACITY = 10;

    //默认构造方法
    public MyArrayList() {
        elem = new Object[DEFAULT_CAPACITY];
    }

    //指定容量的构造方法
    public MyArrayList(int initialCapacity) {
        if(initialCapacity <= 0) {
            throw new IllegalArgumentException("初始容量必须大于0");
        }
        elem = new Object[initialCapacity];
    }

    @Override
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(elem[i] + " ");
        }
        System.out.println();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object toFind) {
        return indexOf(toFind) != -1;
    }

    @Override
    public int indexOf(Object toFind) {
        for (int i = 0; i < size; i++) {
            if(Objects.equals(elem[i],toFind)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean add(E data) {
        if(isFull()) {
            grow();
        }
        elem[size] = data;
        size++;
        return true;
    }

    private boolean isFull() {
        return size == elem.length;
    }

    private void grow() {
        elem = Arrays.copyOf(elem,2 * elem.length);
    }

    @Override
    public void add(int index, E data) {
        checkIndex(index);
        if(isFull()) {
            grow();
        }
        for (int i = size - 1; i >= index ; i--) {
            elem[i + 1] = elem[i];
        }
        elem[index] = data;
        size++;
    }

    //检查下标合法性
    private void checkIndex(int index) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException("添加元素位置不合法");
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public E get(int index) {
        check(index);
        return (E)elem[index];
    }

    //检查下标合法性
    private void check(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("下标越界异常");
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public E set(int index, E data) {
        check(index);
        E oldVal = (E)elem[index];
        elem[index] = data;
        return oldVal;
    }

    @Override
    public boolean remove(Object key) {
        //找到要删除元素的下标
        int index = indexOf(key);
        if(index == -1) {
            return false;
        }
        for (int i = index; i < size - 1; i++) {
            elem[i] = elem[i + 1];
        }
        elem[size - 1] = null;
        size--;
        return true;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elem[i] = null;
        }
        size = 0;
    }
}

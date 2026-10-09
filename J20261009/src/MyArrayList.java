import java.util.Arrays;

public class MyArrayList<T> implements IList<T>{
    private Object[] elem;//底层数组
    private int size;//有效元素个数;
    private static final int DEFAULT_CAPACITY = 10;

    //默认构造方法
    public MyArrayList() {
        this.elem = new Object[DEFAULT_CAPACITY];
    }

    //指定容量构造方法
    public MyArrayList(int initialCapacity) {
        if(initialCapacity <= 0) {
            throw new IllegalArgumentException("初始容量必须大于0");
        }
        this.elem = new Object[initialCapacity];
    }

    @Override
    public boolean add(T data) {
        if(isFull()) {
            grow();
        }
        //扩容完就可以添加元素
        elem[size] = data;
        //维护size
        size++;
        return true;
    }

    private boolean isFull() {
        return this.size == elem.length;
    }

    private void grow() {
        this.elem = Arrays.copyOf(elem,2 * elem.length);
    }

    @Override
    public void add(int pos, T data) {
        checkPos(pos);
        if(isFull()) {
            grow();
        }
        //移动元素
        for(int i = size - 1;i >= pos;i--) {
            this.elem[i + 1] = this.elem[i];
        }
        //移动后就可以添加元素
        this.elem[pos] = data;
        size++;
    }

    //判断下标合法性
    private void checkPos(int pos) {
        if(pos < 0 || pos > size) {
            throw new IndexOutOfBoundsException("添加元素位置不合法 " + pos);
        }
    }

    @Override
    public boolean contains(Object toFind) {
        for(int i = 0;i < size;i++) {
            if(elem[i].equals(toFind)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Object toFind) {
        for (int i = 0; i < size; i++) {
            if(elem[i].equals(toFind)) {
                return i;
            }
        }
        return -1;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T get(int pos) {
        checkIndex(pos);
        return (T)elem[pos];
    }

    private void checkIndex(int pos) {
        if(pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException("下标不合法 " + pos);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public T set(int pos, T value) {
        checkIndex(pos);
        T oldVal = (T)elem[pos];
        this.elem[pos] = value;
        return oldVal;
    }

    @Override
    public boolean remove(Object key) {
        //查找要删除元素的下标
        int index  = indexOf(key);
        //可能找不到
        if(index == -1) {
            return false;
        }
        for (int i = index; i < size - 1; i++) {
            this.elem[i] = this.elem[i + 1];
        }
        this.elem[size - 1] = null;
        size--;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size;i++) {
            this.elem[i] = null;
        }
        this.size = 0;
    }

    @Override
    public void display() {
        for (int i = 0;i < size;i++) {
            System.out.print(elem[i] + " ");
        }
        System.out.println();
    }
}

import java.util.Arrays;

public class MyArrayList<T> implements IList<T> {
    private Object[] elem;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    //默认构造方法
    public MyArrayList() {
        elem = new Object[DEFAULT_CAPACITY];
    }

    //指定初始容量的构造方法
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
    public boolean add(T data) {
       if(isFull()) {
           grow();
       }
       elem[size] = data;
       size++;
       return true;
    }

    //判断是否需要扩容
    private boolean isFull() {
        return this.size == elem.length;
    }

    //扩容方法
    private void grow() {
        elem = Arrays.copyOf(elem,2 * elem.length);
    }

    @Override
    public void add(int index, T data) {
        //判断下标合法性
        checkPos(index);
        //判断是否需要扩容
        if(isFull()) {
            grow();
        }
        //移动元素
        for(int i = size - 1;i >= index;i--) {
            elem[i + 1] = elem[i];
        }
        elem[index] = data;
        this.size++;
    }

    //判断下标合不合法
    private void checkPos(int index) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException("添加元素位置不合法 " + index);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public T get(int index) {
       checkIndex(index);
       return (T)elem[index];
    }

    private void checkIndex(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("下标不合法 " + index);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public T set(int index,T data) {
        checkIndex(index);
        T oldVal = (T)elem[index];
        elem[index] = data;
        return oldVal;
    }

    @Override
    public boolean contains(Object toFind) {
        for (int i = 0; i < size; i++) {
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

    @Override
    public boolean remove(T key) {
       //查询要删除那个元素的下标
        int index = indexOf(key);
        if(index == -1) {
            return false;
        }
        //执行完上面的代码就已经找到要删除那个元素的下标了
        //执行覆盖
        for (int i = index; i < size - 1; i++) {
            elem[i] = elem[i + 1];
        }
        //覆盖完
        elem[size - 1] = null;
        this.size--;
        return true;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elem[i] = null;
        }
        this.size = 0;
    }
}

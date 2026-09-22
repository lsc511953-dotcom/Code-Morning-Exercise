import java.nio.file.attribute.PosixFileAttributes;
import java.util.Arrays;

public class MyArrayList <T> implements IList<T>{
    private Object[] elem;//底层数组
    private int size;//有效元素个数
    private static final int DEFAULT_CAPACITY = 10;//默认容量

    //无参构造方法
    public MyArrayList() {
        elem = new Object[DEFAULT_CAPACITY];
    }

    //指定容量的构造方法
    public MyArrayList(int initial) {
        if(initial <= 0) {
            throw new IllegalArgumentException("初始容量必须大于0");
        }
        elem = new Object[initial];
    }

    @Override
    public boolean add(T data) {
        //判满
        if(isFull()) {
            elem = Arrays.copyOf(elem,2 * elem.length);
        }
        //不满可以正常插入
        elem[size] = data;
        size++;
        return true;
    }

    //判满方法
    private boolean isFull() {
        return this.elem.length == this.size;
    }

    @Override
    public void add(int pos, T data) {
        //判断下标合法性
        checkPos(pos);
        //一样要判满
        if(isFull()) {
            elem = Arrays.copyOf(elem,2 * elem.length);
        }
        //移动元素
        for(int i = this.size - 1; i >= pos;i--) {
            elem[i + 1] = elem[i];
        }
        //添加元素
        elem[pos] = data;
        size++;
    }

    private void checkPos(int pos) {
        if(pos < 0 || pos > this.size) {
            throw new IndexOutOfBoundsException("添加元素位置不合法: pos = "  + pos );
        }
    }

    @Override
    public boolean contains(Object toFind) {
        //查找元素
        for(int i = 0;i < this.size;i++) {
            if(elem[i].equals(toFind)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Object toFind) {
        //查找元素
        for(int i = 0;i < this.size;i++) {
            if(elem[i].equals(toFind)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public T get(int pos) {
        //判断下标合法性
        checkPosBySetOrGet(pos);
        return (T)elem[pos];
    }

    private void checkPosBySetOrGet(int pos) {
        if(pos < 0 || pos >= this.size) {
            throw new IndexOutOfBoundsException("获取元素位置不合法");
        }
    }

    @Override
    public T set(int pos, T value) {
        checkPosBySetOrGet(pos);
        T oldValue = (T)elem[pos];
        elem[pos] = value;
        return oldValue;
    }

    @Override
    public boolean remove(Object toRemove) {
       //找到要删除元素的下标
        int index = indexOf(toRemove);
        if(index == -1) {
            return false;
        }
        //覆盖元素
        for (int i = index; i < this.size - 1; i++) {
            elem[i] = elem[i + 1];
        }
        elem[this.size - 1] = null;
        this.size--;
        return true;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void clear() {
        for (int i = 0;i < this.size;i++) {
            this.elem[i] = null;
        }
        this.size = 0;
    }

    @Override
    public void display() {
        for (int i = 0; i < this.size; i++) {
            System.out.print(elem[i] + " ");
        }
        System.out.println();
    }
}

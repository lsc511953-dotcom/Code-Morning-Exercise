import java.util.Arrays;

public class MyArrayList<T> implements IList<T> {
    private Object[] elem;//底层数组
    private int size;//有效元素个数
    private static final int DEFAULT_CAPACITY = 10;//默认容量

    //默认初始化
    public MyArrayList(){
        this.elem = new Object[DEFAULT_CAPACITY];
    }
    //指定容量初始化
    public MyArrayList(int initialCapacity) {
        if(initialCapacity < 0) {
            throw new IllegalArgumentException("初始容量必须大于0");
        }
        this.elem = new Object[initialCapacity];
    }

    @Override
    public boolean add(T data) {
        //判满
        if(isFull()) {
            grow();
        }
        //添加元素
        this.elem[size] = data;
        this.size++;
        return true;
    }

    //判满方法
    private boolean isFull(){
        return this.size == this.elem.length;//判断有效元素是不是已经占满数组了
    }

    //扩容方法
    private void grow() {
        this.elem = Arrays.copyOf(this.elem,this.elem.length * 2);
    }


    @Override
    public void add(int pos, T data) {
        //判断下标有没有越界
        checkPos(pos);
        //判满
        if(isFull()) {
          grow();
        }
        //添加元素
        for (int i = this.size - 1; i >= pos ; i--) {
            this.elem[i + 1] = this.elem[i];
        }
        this.elem[pos] = data;
        this.size++;
    }

    //判断下标是否合法
    private void checkPos(int pos) {
        if(pos < 0 || pos > this.size) {
            throw new IndexOutOfBoundsException("添加元素位置不合法 " + pos);
        }
    }


    @Override
    public boolean contains(Object toFind) {
        for (int i = 0; i < this.size; i++) {
            if(this.elem[i].equals(toFind)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Object toFind) {
        for (int i = 0; i < this.size; i++) {
            if(this.elem[i].equals(toFind)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public T get(int pos) {
        //判断是否越界异常
        checkPosByGetOrGet(pos);
        return (T)this.elem[pos];
    }

    //检查下标是否越界异常
    private void checkPosByGetOrGet(int pos) {
        if(pos < 0 || pos >= this.size) {
            throw new IndexOutOfBoundsException("获取元素位置不合法 " + pos);
        }
    }

    @Override
    public T set(int pos, T value) {
        checkPosByGetOrGet(pos);
        T oldValue = (T)elem[pos];
        this.elem[pos] = value;
        return oldValue;
    }

    @Override
    public boolean remove(Object toRemove) {
        //先找到要删除的那个元素的下标
        int index = indexOf(toRemove);
        if(index == -1) {
            return false;
        }
        //移动元素进行覆盖
        for(int i = index;i < this.size - 1;i++) {
            this.elem[i] = this.elem[i + 1];
        }
        this.elem[this.size - 1] = null;
        this.size--;
        return true;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void clear() {
        for (int i = 0; i < this.size; i++) {
            this.elem[i] = null;
        }
        this.size = 0;
    }

    @Override
    public void display() {
        for (int i = 0;i < this.size;i++) {
            System.out.print(this.elem[i] + " ");
        }
        System.out.println();
    }
}

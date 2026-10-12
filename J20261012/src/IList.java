public interface IList<T> {
    //打印顺序表
    void display();
    //获取顺序表长度
    int size();
    //尾插
    boolean add(T data);
    //任意位置插入
    void add(int index,T data);
    //获取这个下标的元素
    T get(int index);
    //修改这个下标的元素
    T set(int index,T data);
    //判断是否包含某个元素
    boolean contains(Object toFind);
    //判断某个元素的下标
    int indexOf(Object toFind);
    //删除key元素
    boolean remove(T key);
    //清空顺序表
    void clear();
}

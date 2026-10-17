public interface IList<T>{
    //打印顺序表
    void display();
    //获取链表长度
    int size();
    //添加元素
    boolean add(T data);
    //在任意位置插入
    void add(int index,T data);
    //判断是否包含某个元素
    boolean contains(Object toFind);
    //判断某个元素的下标
    int indexOf(Object toFInd);
    //获取某个元素的下标
    T get(int index);
    //修改某个下标的元素
    T set(int index,T data);
    //删除
    boolean remove(T data);
    //清空
    void clear();
}

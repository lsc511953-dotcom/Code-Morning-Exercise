public interface IList<T> {
    //打印顺序表
    void display();
    //获取顺序表长度
    int size();
    //判断顺序表是否存在某一个元素
    boolean contains(Object toFind);
    //获取该元素的下标
    int indexOf(Object toFind);
    //尾插
    boolean add(T data);
    //任意位置插入
    void add(int index,T data);
    //获取该下标的元素
    T get(int index);
    //修改改下标的元素
    T set(int index,T data);
    //删除:删除出现key的元素
    boolean remove(T key);
    //清空顺序表
    void clear();
}

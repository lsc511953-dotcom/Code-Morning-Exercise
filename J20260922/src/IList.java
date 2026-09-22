public interface IList<T> {
    //尾插元素
    boolean add(T data);
    //在pos位置新增元素
    void add(int pos,T data);
    //判定是否包含某个元素
    boolean contains(Object toFind);
    //查找某个元素对应位置
    int indexOf(Object toFind);
    //获取pos位置的元素
    T get(int pos);
    //给pos位置元素设为value
    T set(int pos,T value);
    //删除第一次出现的关键字key
    boolean remove(Object toRemove);
    //获取顺序表的长度
    int size();
    //清空顺序表
    void clear();
    //打印顺序表
    void display();
}

public interface IList<T> {
    //打印顺序表
    void display();
    //获取顺序表长度
    int size();
    //判断是否包含指定元素
    boolean contains(Object toFind);
    //获取指定元素的下标
    int indexOf(Object toFind);
    //添加
    boolean add(T data);
    //任意位置插入
    void add(int index,T data);
    //获取
    T get(int index);
    //修改
    T set(int index,T data);
    //删除第一次出现的指定元素
    boolean remove(T key);
    //清空顺序表
    void clear();
}

public interface IList<E> {
    //打印顺序表
    void display();
    //获取顺序表长度
    int size();
    //判断顺序表是否存在指定元素
    boolean contains(Object toFind);
    //获取指定元素下标
    int indexOf(Object toFind);
    //添加
    boolean add(E data);
    //在任意位置插入
    void add(int index,E data);
    //获取
    E get(int index);
    //修改
    E set(int index,E data);
    //删除第一次出现的指定元素
    boolean remove(E key);
    //清空顺序表
    void clear();
}

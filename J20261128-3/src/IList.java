public interface IList<E> {
    //打印链表
    void display();
    //获取链表长度
    int size();
    //判断链表是否存在指定元素
    boolean contains(E toFind);
    //头插
    void addFirst(E data);
    //尾插
    void addLast(E data);
    //在任意位置插入
    void add(int index,E data);
    //删除第一次出现的指定元素
    boolean remove(E data);
    //删除所有指定元素
    boolean removeAllKeys(E key);
    //清空链表
    void clear();
}

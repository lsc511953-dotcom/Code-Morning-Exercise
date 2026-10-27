public interface IList<T> {
    //打印链表
    void display();
    //获取链表长度
    int size();
    //判断链表是否存在某一个元素
    boolean contains(Object toFind);
    //头插
    void addFirst(T data);
    //尾插
    void addLast(T data);
    //在任意位置插入
    void add(int index,T data);
    //删除:删除第一次出现key的节点
    boolean remove(T key);
    //删除全部出现key的节点
    boolean removeAllKeys(T key);
    //清空链表
    void clear();
}

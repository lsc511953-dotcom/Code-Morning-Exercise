public interface IList<T> {
    //遍历
    void display();
    //统计链表长度
    int size();
    //查找:判断关键字key是否存在
    boolean contains(T key);
    //头插法
    void addFirst(T data);
    //尾插
    void addLast(T data);
    //在任意位置插入.第一个节点的下标为0
    void add(int index,T data);
    //删除:移除第一次出现的key节点
    boolean remove(T key);
    //删除: 移除所有值为key的节点
    void removeAllKey(T key);
    //清空:释放链表所有节点
    void clear();
}

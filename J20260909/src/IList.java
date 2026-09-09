public interface IList<T> {
    // 遍历:打印链表所有节点
    void display();
    //统计: 获取链表长度
    int size();
    //查找: 判断关键字key是否存在
    boolean contains(T key);
    //头插法
    void addFirst(T data);
    //尾插法
    void addLast(T data);
    //在任意位置插入
    void add(int index,T data);
    //删除第一次出现的key节点
    boolean remove(T key);
    //删除所有值为key的节点
    void removeAllKey(T key);
    //清空链表
    void clear();
}

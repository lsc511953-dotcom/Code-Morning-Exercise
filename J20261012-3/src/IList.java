public interface IList<T> {
    //打印链表
    void display();
    //获取链表长度
    int size();
    //头插
    void addFirst(T data);
    //尾插
    void addLast(T data);
    //任意位置插入
    void add(int index,T data);
    //删除
    boolean remove(T key);
    //删除
    boolean removeAllKeys(T key);
    //清空链表
    void clear();
}

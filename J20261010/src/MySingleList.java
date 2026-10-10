public class MySingleList<T> implements IList<T> {
    public static class ListNode<T>{
        T val;
        ListNode<T> next;

        public ListNode(T val) {
            this.val = val;
        }
    }
    ListNode<T> head;//链表的头引用
    @Override
    public void display() {
        ListNode<T> cur = this.head;
        while(cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }

    @Override
    public int size() {
        ListNode<T> cur = this.head;
        int count = 0;
        while(cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    @Override
    public boolean contains(T key) {
        ListNode<T> cur = this.head;
        while(cur != null) {
            if(cur.val.equals(key)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    @Override
    public void addFirst(T data) {
        ListNode<T> node = new ListNode<>(data);
        node.next = this.head;
        this.head = node;
    }

    @Override
    public void addLast(T data) {
        ListNode<T> node = new ListNode<>(data);
        //链表为空
        if(this.head == null) {
            this.head = node;
            return;
        }
        //链表不为空
        //要找到最后一个节点,时间复杂度为O(N)
        ListNode<T> cur = this.head;
        while(cur.next != null) {
            cur = cur.next;
        }
        //到这里已经找到最后一个节点了
        cur.next = node;
    }

    @Override
    public void add(int index, T data) {
        int len = size();
        //检查下标合法性
        if(index < 0 || index > len) {
            throw new IndexOutOfBoundsException("添加元素元素位置不合法 " + index);
        }
        //头插
        if(index == 0) {
            addFirst(data);
            return;
        }
        //尾插
        if(index == len) {
            addLast(data);
            return;
        }
        //中间位置插入
        ListNode<T> prevNode = prevNodeByIndex(index);//找到前一个节点
        ListNode<T> node = new ListNode<>(data);//实例化一个节点
        node.next = prevNode.next;
        prevNode.next = node;
    }

    //找前一个节点的方法
    private ListNode<T> prevNodeByIndex(int index) {
        ListNode<T> cur = this.head;
        int count = 0;
        while(count < index - 1) {
           cur = cur.next;
           count++;
        }
        return cur;
    }

    @Override
    public boolean remove(T key) {
        //链表为空
        if(this.head == null) {
            return false;
        }
        //链表不为空
        //头节点
        if(this.head.val.equals(key)) {
            this.head = this.head.next;
            return true;
        }
        ListNode<T> prev = prevNodeByVal(key);//找到前一个节点
        //找不到节点
        if(prev == null) {
            return false;
        }
        //找到节点
        prev.next = prev.next.next;
        return true;
    }

    //找到要删除前一个节点
    private ListNode<T> prevNodeByVal(T key) {
        ListNode<T> prev = this.head;
        while(prev.next != null) {
            if(prev.next.val.equals(key)) {
                return prev;
            }
            prev = prev.next;
        }
        return null;
    }

    @Override
    public void removeAllKey(T key) {
        if(this.head == null) {
            return;
        }
        ListNode<T> prev = this.head;
        ListNode<T> cur = this.head.next;
        while(cur != null) {
            if(cur.val.equals(key)) {
                prev.next = cur.next;
            }else{
                prev = cur;
            }
            cur = cur.next;
        }
        //检查头节点
        if(this.head.val.equals(key)) {
            this.head = this.head.next;
        }
    }

    @Override
    public void clear() {
        this.head = null;
    }
}

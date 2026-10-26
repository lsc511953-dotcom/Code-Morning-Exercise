public class MySingleList <T> implements IList<T>{
    private class ListNode<T> {
        T val;
        ListNode<T> next;

        public ListNode(T val) {
            this.val = val;
        }
    }
    private ListNode<T> head;
    @Override
    public void display() {
        ListNode<T> cur = this.head;
        while(cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
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
    public boolean contains(T toFind) {
        ListNode<T> cur = this.head;
        while(cur != null) {
            if(cur.val.equals(toFind)) {
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
        //找到最后一个节点
        ListNode<T> cur = this.head;
        while(cur.next != null) {
            cur = cur.next;
        }
        //拿到最后一个节点
        cur.next = node;
    }

    @Override
    public void add(int index, T data) {
        //判断下标合法性
        int len = size();
        if(index < 0 || index > len) {
            throw new IndexOutOfBoundsException("添加元素位置不合法");
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
        ListNode<T> node = new ListNode<>(data);
        //找到前一个节点
        ListNode<T> prevNode = findPrevByIndex(index);
        node.next = prevNode.next;
        prevNode.next = node;
    }

    private ListNode<T> findPrevByIndex(int index) {
        ListNode<T> cur = this.head;
        int count = 0;
        while(count < index - 1) {
            count++;
            cur = cur.next;
        }
        return cur;
    }

    @Override
    public boolean remove(T key) {
        if(this.head == null){
            return false;
        }
        //删除头结点
        if(this.head.val.equals(key)) {
            this.head = this.head.next;
            return true;
        }
        ListNode<T> prev = findPrevNodeByVal(key);
        if(prev == null) {
            return false;
        }
        prev.next = prev.next.next;
        return true;
    }

    //找到前一个节点
    private ListNode<T> findPrevNodeByVal(T key) {
        ListNode<T> prev = this.head;
        while(prev.next != null){
            if(prev.next.val.equals(key)) {
                return prev;
            }
            prev = prev.next;
        }
        return null;
    }

    @Override
    public boolean removeAllKeys(T key) {
        if(this.head == null) {
            return false;
        }
        boolean removed = false;
        ListNode<T> prev = this.head;
        ListNode<T> cur = this.head.next;
        while(cur != null) {
            if(cur.val.equals(key)) {
                prev.next = cur.next;
                removed = true;
            }else{
                prev = cur;
            }
            cur = cur.next;
        }
        if(this.head.val.equals(key)) {
            this.head = this.head.next;
            removed = true;
        }
        return removed;
    }

    @Override
    public void clear() {
        this.head = null;
    }
}

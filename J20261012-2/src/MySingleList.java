public class MySingleList<T> implements IList<T> {
    private static class ListNode<T>{
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
    public void addFirst(T data) {
        ListNode<T> node = new ListNode<>(data);
        node.next = this.head;
        this.head = node;
    }

    @Override
    public void addLast(T data) {
        ListNode<T> node = new ListNode<>(data);
        if(this.head == null) {
            this.head = node;
            return;
        }
        //链表不为空
        //找到最后一个节点
        ListNode<T> cur = this.head;
        while(cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
    }

    @Override
    public void add(int index, T data) {
        int len = size();
        //判断下标合法性
        if(index < 0 || index > len) {
            throw new IndexOutOfBoundsException("添加元素位置异常 " + index);
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
        ListNode<T> prev = findPrevNodeByIndex(index);
        node.next = prev.next;
        prev.next = node;
    }

    //找到前一个节点
    private ListNode<T> findPrevNodeByIndex(int index) {
        ListNode<T> cur = this.head;
        int count = 0;
        while(count < index - 1) {
            count++;
            cur = cur.next;
        }
        return cur;
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
    public boolean remove(T key) {
        if(this.head == null) {
            return false;
        }
        //要删除的是头节点
        if(this.head.val.equals(key)) {
            this.head = this.head.next;
            return true;
        }
        //找到前一个节点
        ListNode<T> prev = findPrevNodeByVal(key);
        if(prev == null) {
            return false;
        }
        prev.next = prev.next.next;
        return true;
    }

    private ListNode<T> findPrevNodeByVal(T val) {
        ListNode<T> prev = this.head;
        while(prev.next != null) {
            if(prev.next.val.equals(val)) {
                return prev;
            }
            prev = prev.next;
        }
        return null;
    }

    @Override
    public void removeAllKeys(T key) {
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
        if(this.head.val.equals(key)) {
            this.head = this.head.next;
        }
    }

    @Override
    public void clear() {
        this.head = null;
    }
}


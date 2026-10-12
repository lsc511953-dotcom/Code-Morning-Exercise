public class MyLinkedList<T> implements IList<T>{
    private static class ListNode<T>{
        T val;
        ListNode<T> prev;
        ListNode<T> next;

        public ListNode(T val) {
            this.val = val;
        }
    }
    private ListNode<T> head;
    private ListNode<T> last;
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
        //链表为空
        if(this.head == null) {
            this.head = node;
            this.last = node;
            return;
        }
        node.next = this.head;
        this.head.prev = node;
        this.head = node;
    }

    @Override
    public void addLast(T data) {
        ListNode<T> node = new ListNode<>(data);
        //链表为空
        if(this.head == null) {
            this.head = node;
            this.last = node;
            return;
        }
        this.last.next = node;
        node.prev = this.last;
        this.last = node;
    }

    @Override
    public void add(int index, T data) {
        int len = size();
        //判断下标合法性
        if(index < 0 || index > len) {
            throw new IndexOutOfBoundsException("添加元素位置不合法 " + index);
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
        //中间位置插
        //要找到本节点
        ListNode<T> cur = search(index);
        ListNode<T> node = new ListNode<>(data);
        node.next = cur;
        node.prev = cur.prev;
        cur.prev.next = node;
        cur.prev = node;
    }

    private ListNode<T> search(int index) {
        ListNode<T> cur = this.head;
        int count = 0;
        while(count < index) {
            count++;
            cur = cur.next;
        }
        return cur;
    }

    @Override
    public boolean remove(T key) {
       ListNode<T> cur = this.head;
       while(cur != null) {
           if(cur.val.equals(key)) {
               //头节点
               if(this.head == cur) {
                   this.head = this.head.next;
                   if(this.head == null) {
                       this.last = null;
                   }else{
                       this.head.prev = null;
                   }
               }else{
                   if(this.last == cur) {
                       this.last = this.last.prev;
                       this.last.next = null;
                   }else{
                       cur.prev.next = cur.next;
                       cur.next.prev = cur.prev;
                   }
               }
               return true;
           }
           cur = cur.next;
       }
       return false;
    }

    @Override
    public boolean removeAllKeys(T key) {
        ListNode<T> cur = this.head;
        boolean removed = false;
        while(cur != null) {
            if(cur.val.equals(key)) {
                //头节点
                if(this.head == cur) {
                    this.head = this.head.next;
                    if(this.head == null) {
                        this.last = null;
                    }else{
                        this.head.prev = null;
                    }
                }else{
                    if(this.last == cur) {
                        this.last = this.last.prev;
                        this.last.next = null;
                    }else{
                        cur.prev.next = cur.next;
                        cur.next.prev = cur.prev;
                    }
                }
                removed = true;
            }
            cur = cur.next;
        }
        return removed;
    }

    @Override
    public void clear() {
        ListNode<T> cur = this.head;
        while(cur != null) {
            ListNode<T> nextNode = cur.next;
            cur.val = null;
            cur.prev = null;
            cur.next = null;
            cur = nextNode;
        }
        this.head = null;
        this.last = null;
    }
}

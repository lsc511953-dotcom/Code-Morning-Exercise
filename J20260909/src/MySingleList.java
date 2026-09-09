public class MySingleList<T> implements IList<T>{

    public static class ListNode<T>{
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
        //实例化一个节点
        ListNode<T> node = new ListNode<>(data);
        //绑定后面
        node.next = this.head;
        this.head = node;
    }

    @Override
    public void addLast(T data) {
        //实例化一个节点
        ListNode<T> node = new ListNode<>(data);
        //链表为空
        if(this.head == null) {
            this.head = node;
            return;
        }
        ListNode<T> cur = this.head;
        //链表不为空,找到最后一个节点
        while(cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
    }

    @Override
    public void add(int index, T data) {
        int len = size();
        if(index < 0 || index > len) {
            throw new IndexOutOfBoundsException("添加元素位置异常");
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
        //任意位置插入
        //找到要插入的位置的前一个节点
        ListNode<T> prev = findPrevByIndex(index);
        ListNode<T> node = new ListNode<>(data);
        //先绑定后面
        node.next = prev.next;
        prev.next = node;
    }

    private ListNode<T> findPrevByIndex(int index){
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

        if (this.head.val.equals(key)) {
            this.head = this.head.next;
            return true;
        }

        //找到前一个节点
        ListNode<T> prev = findPrevByValue(key);
        if(prev == null) {
            return false;
        }
        prev.next = prev.next.next;
        return true;
    }

    private ListNode<T> findPrevByValue(T key) {
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
        //链表为空
        if(this.head == null) {
            return;
        }
        ListNode<T> prev = this.head;
        ListNode<T> cur = this.head.next;
        while(cur != null) {
            if(cur.val.equals(key)) {
                prev.next = cur.next;
            }else {
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

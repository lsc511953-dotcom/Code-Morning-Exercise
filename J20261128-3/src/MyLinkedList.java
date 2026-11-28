import java.util.Objects;

public class MyLinkedList<E> implements IList<E> {
    private static class ListNode<E> {
        E val;
        ListNode<E> prev;
        ListNode<E> next;

        public ListNode(E val) {
            this.val = val;
        }
    }
    private ListNode<E> head;
    private ListNode<E> last;

    @Override
    public void display() {
        ListNode<E> cur = this.head;
        while(cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    @Override
    public int size() {
        ListNode<E> cur = this.head;
        int count = 0;
        while(cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    @Override
    public boolean contains(E toFind) {
        ListNode<E> cur = this.head;
        while(cur != null) {
            if(Objects.equals(cur.val, toFind)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    @Override
    public void addFirst(E data) {
        ListNode<E> node = new ListNode<>(data);
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
    public void addLast(E data) {
        ListNode<E> node = new ListNode<>(data);
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
    public void add(int index, E data) {
        int len = size();
        if(index < 0 || index > len) {
            throw new IndexOutOfBoundsException("添加元素位置不合法");
        }
        if(index == 0) {
            addFirst(data);
            return;
        }
        if(index == len) {
            addLast(data);
            return;
        }
        //找到该节点
        ListNode<E> cur = findNodeByIndex(index);
        ListNode<E> node = new ListNode<>(data);
        node.next = cur;
        node.prev = cur.prev;
        cur.prev.next = node;
        cur.prev = node;
    }

    private ListNode<E> findNodeByIndex(int index) {
        ListNode<E> cur = this.head;
        int count = 0;
        while(count < index) {
            count++;
            cur = cur.next;
        }
        return cur;
    }

    @Override
    public boolean remove(E key) {
        ListNode<E> cur = this.head;
        while(cur != null) {
            if(Objects.equals(cur.val,key)) {
                if(cur == this.head) {
                    this.head = this.head.next;
                    if(this.head == null) {
                        this.last = null;
                    }else{
                        this.head.prev = null;
                    }
                }else if(cur == this.last){
                    this.last = this.last.prev;
                    this.last.next = null;
                }else{
                    cur.prev.next = cur.next;
                    cur.next.prev = cur.prev;
                }
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    @Override
    public boolean removeAllKeys(E key) {
        ListNode<E> cur = this.head;
        boolean removed = false;
        while(cur != null) {
            if(Objects.equals(cur.val,key)) {
                if(cur == this.head) {
                    this.head = this.head.next;
                    if(this.head == null) {
                        this.last = null;
                    }else{
                        this.head.prev = null;
                    }
                }else if(cur == this.last){
                    this.last = this.last.prev;
                    this.last.next = null;
                }else{
                    cur.prev.next = cur.next;
                    cur.next.prev = cur.prev;
                }
                removed = true;
            }
            cur = cur.next;
        }
        return removed;
    }

    @Override
    public void clear() {
        ListNode<E> cur = this.head;
        while(cur != null) {
            ListNode<E> nextTemp = cur.next;
            cur.val = null;
            cur.prev = null;
            cur.next = null;
            cur = nextTemp;
        }
        this.head = null;
        this.last = null;
    }
}

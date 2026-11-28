import java.util.Objects;

public class MySingleList<E> implements IList<E> {
    private static class ListNode<E> {
        E val;
        ListNode<E> next;

        public ListNode(E val) {
            this.val = val;
        }
    }
    private ListNode<E> head;

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
    public boolean contains(Object toFind) {
        ListNode<E> cur = this.head;
        while(cur != null) {
            if(Objects.equals(cur.val,toFind)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    @Override
    public void addFirst(E data) {
        ListNode<E> node = new ListNode<>(data);
        node.next = this.head;
        this.head = node;
    }

    @Override
    public void addLast(E data) {
        ListNode<E> node = new ListNode<>(data);
        if(this.head == null) {
            this.head = node;
            return;
        }
        //找到最后一个节点
        ListNode<E> cur = this.head;
        while(cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
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
        //找到前一个节点
        ListNode<E> prev = findPrevNodeByIndex(index);
        ListNode<E> node = new ListNode<>(data);
        node.next = prev.next;
        prev.next = node;
    }

    private ListNode<E> findPrevNodeByIndex(int index) {
        ListNode<E> cur = this.head;
        int count = 0;
        while(count < index - 1) {
            count++;
            cur = cur.next;
        }
        return cur;
    }

    @Override
    public boolean remove(E key) {
        if(this.head == null) {
            return false;
        }
        if(Objects.equals(this.head.val,key)) {
            this.head = this.head.next;
            return true;
        }
        //找到前一个节点
        ListNode<E> prev = findPrevNodeByVal(key);
        if(prev == null) {
            return false;
        }
        prev.next = prev.next.next;
        return true;
    }

    private ListNode<E> findPrevNodeByVal(E val) {
        ListNode<E> prev = this.head;
        while(prev.next != null) {
            if(Objects.equals(prev.next.val,val)) {
                return prev;
            }
            prev = prev.next;
        }
        return null;
    }

    @Override
    public boolean removeAllKeys(E key) {
        if(this.head == null) {
            return false;
        }
        boolean removed = false;
        ListNode<E> prev = this.head;
        ListNode<E> cur = this.head.next;
        while(cur != null) {
            if(Objects.equals(cur.val,key)) {
                prev.next = cur.next;
                removed = true;
            }else{
                prev = cur;
            }
            cur = cur.next;
        }
        if(Objects.equals(this.head.val,key)) {
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

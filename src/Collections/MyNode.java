package Collections;

public class MyNode<T> {
    private T value;
    private MyNode next,prev;

    public MyNode(T value, MyNode next, MyNode prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }

    public void setNext(MyNode next) {
        this.next = next;
    }

    public void setPrev(MyNode prev) {
        this.prev = prev;
    }

    public T getValue() {
        return value;
    }

    public MyNode getNext() {
        return next;
    }

    public MyNode getPrev() {
        return prev;
    }
}

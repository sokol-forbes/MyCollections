public class MyLinkedList<T> {


    private MyNode<T> start, end;
    private Integer size;

    public MyLinkedList() {
        size = 0;
        start = null;
        end = null;
    }

    public MyLinkedList(MyNode<T> start, MyNode<T> end, Integer size) {
        this.start = start;
        this.end = end;
        this.size = size;
    }

    public Integer size() {
        return size;
    }

    public void add(Integer index, T element) {

    }

    public void add(T element) {
        MyNode node = new MyNode(element, null, null);
        if (start == null && end == null) {
            start = node;
            end = node;
        } else {
            end.setNext(node);
            node.setPrev(end);
            end = node;
        }
        size += 1;
    }

    public void remove(Integer index) throws OutIndexException {
        if (index >= size || index < 0) {
            throw new OutIndexException();
        }
        MyNode current = getNode(index);
        if (index > 0 && index < size - 1) {

            current.getPrev().setNext(current.getNext());
            current.getNext().setPrev(current.getPrev());
        }
        if (index == 0)
            start = start.getNext();
        if (index == size - 1)
            end = end.getPrev();
        size -= 1;


    }

    public T getValue(Integer index) throws OutIndexException {
        return (T) getNode(index).getValue();
    }

    public MyNode getNode(Integer index) throws OutIndexException {
        if (index >= size || index < 0) {
            throw new OutIndexException();
        }
        MyNode current = start;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current;
    }

    public void set(T element) {
        MyNode<T> node = new MyNode<T>(element, null, end);
        end.setNext(node);
    }

    public MyLinkedList<T> subList(Integer startIndex, Integer lastIndex) {
        MyLinkedList<T> list = new MyLinkedList<>();
        try {
            list = new MyLinkedList<T>(getNode(startIndex), getNode(lastIndex), (lastIndex - startIndex + 1));
        } catch (OutIndexException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public String toString() {
        String str = "[";
        for (int i = 0; i < size; i++) {

            try {
                str += (getValue(i) + ", ");
            } catch (OutIndexException e) {
                System.out.println(e.getMessage());
            }

        }
        str += "]";
        return str;
    }

}

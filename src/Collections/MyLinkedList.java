package Collections;

/**
 * Собственная реализация LinkedList<T>
 *
 * @author Alexander Sokolovsky
 */
public class MyLinkedList<T> {
    /**
     * Поля хранищие данные первого и последнего узла списка
     * Инициализированная размернотью 10
     */
    private MyNode<T> start, end;
    /**
     * Поле для хранения текущего размера списка
     */
    private Integer size;

    /**
     * Конструктор без параметров для инициализации списка нулевого размера
     */
    public MyLinkedList() {
        size = 0;
        start = null;
        end = null;
    }

    /**
     * Конструктор  для инициализации списка
     *
     * @param start первый элемент списка
     * @param end   последний элемент списка
     * @param size  размер списка
     */
    public MyLinkedList(MyNode<T> start, MyNode<T> end, Integer size) {
        this.start = start;
        this.end = end;
        this.size = size;
    }

    /**
     * Конструктор для инициализации списка с одним узлом
     *
     * @param node узел списка
     */
    public MyLinkedList(MyNode<T> node) {
        this.start = node;
        this.end = node;
        this.size = 1;
    }

    /**
     * Метод для получения текущего размера списка
     *
     * @return size Размер списка{@link MyLinkedList size}
     */
    public Integer size() {
        return size;
    }
    /**
     * Метод для вставки элемента в список по индексу
     * @param element вставляемы элемент
     * @param index место вставки
     */
    public void add(Integer index, T element) throws OutIndexException {
        MyNode<T> node = new MyNode<>(element, null, null);
        if (start == null && end == null) {
            start = node;
            end = node;
        } else {
            MyNode<T> current = getNode(index);
            node.setPrev(current.getPrev());
            node.setNext(current);
            current.setPrev(node);
            current.getPrev().setNext(node);
        }
        size += 1;
    }
    /**
     * Метод для вставки элемента в конец списка
     * @param element вставляемы элемент
     */
    public void add(T element) {
        MyNode<T> node = new MyNode<T>(element, null, null);
        if (start == null && end == null) {
            start = node;
        } else {
            end.setNext(node);
            node.setPrev(end);
        }
        end = node;
        size += 1;
    }
    /**
     * Метод для удаления элемента в списке по индексу
     * @param index место удаления
     */
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
            start = (MyNode<T>) start.getNext();
        if (index == size - 1)
            end = (MyNode<T>)end.getPrev();
        size -= 1;


    }
    /**
     * Метод для получения элемента в списке по индексу
     * @param index место необходимого элемента
     * @return значение хранящееся в узле по индексу
     */
    public T getValue(Integer index) throws OutIndexException {
        return (T) getNode(index).getValue();
    }
    /**
     * Метод для получения элемента в списке по индексу
     * @param index место необходимого элемента
     * @return значение хранящееся в узле по индексу
     */
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
    /**
     * <p>Метод для получения части коллекции</p>
     * @param startIndex индекс начала части коллекции
     * @param lastIndex индекс конца части коллекции
     * @throws OutIndexException В случае невалидного индекса
     * @return Возвращает {@link MyLinkedList} c {@link @param startIndex} до {@link @param lastIndex}
     */
    public MyLinkedList<T> subList(Integer startIndex, Integer lastIndex) {
        MyLinkedList<T> list = new MyLinkedList<>();
        try {
            list = new MyLinkedList<T>(getNode(startIndex), getNode(lastIndex), (lastIndex - startIndex + 1));
        } catch (OutIndexException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    /**
     * <p>Метод для сериализации коллекции в строку</p>
     * @return Возвращает строку содержащую объекты коллекции
     */
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        for (int i = 0; i < size; i++) {

            try {
                str.append(getValue(i)).append(", ");
            } catch (OutIndexException e) {
                System.out.println(e.getMessage());
            }

        }
        str.append("]");
        return str.toString();
    }

}

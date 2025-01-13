

/**
 * Собственная реализация ArrayList<T>
 *
 * @author Alexander Sokolovsky
 */
public class MyArrayList<T> {
    /**
     * Вместительность
     * Инициализированная размернотью 10
     */
    private int capatity = 10;
    /**
     * Размер списка
     */
    private int size = 0;
    /**
     * Массив объектов типа Т
     */
    private T[] obj;

    /**
     * <p>Конструктор без параметров для инициализации списка стандартной размерности
     * </p>
     */
    public MyArrayList() {
        obj = (T[]) new Object[capatity];
        obj[0] = null;
    }

    /**
     * <p>Метод для доступа к объекту типа Т по индексу</p>
     *
     * @param index индекс необходимого объекта
     * @return Объект типа Т
     * @throws OutIndexException В случае невалидного индекса
     */
    public T get(int index) throws OutIndexException {
        if (index > size || index < 0)
            throw new OutIndexException();
        return (T) obj[index];
    }

    /**
     * <p>Метод для установки элемента в необходимую позицию</p>
     *
     * @param index позиция объекта который хотим изменить
     * @throws OutIndexException В случае невалидного индекса
     */
    public void set(int index, T object) throws OutIndexException {
        if (index > size || index < 0)
            throw new OutIndexException();
        else obj[index] = object;
    }

    /**
     * <p>Метод для получения текущего размера коллекции</p>
     * @return Текущий размер коллекции
     */
    public int size() {
        return size;
    }

    /**
     * <p>Метод для добавления объекта в коллекцию</p>
     *
     * @param object  Объект который необходимо добавить
     * @return Объект типа Т
     * @throws OutIndexException В случае невалидного индекса
     */
    public void add(T object) {
        obj[size] = object;
        size += 1;
    }
    /**
     * <p>Метод для вставки объекта типа Т на необходимую полизицю с перекопированием следующих элементов</p>
     * @param index позиция для вставки
     * @param object Объект для вставки
     * @throws OutIndexException В случае невалидного индекса
     */
    public void add(int index, T object) throws OutIndexException {
        if (index > size || index <= 0)
            throw new OutIndexException();
        else {
            if (size == capatity) {
                enlargement();
            }

            System.arraycopy(obj, index, obj, index + 1, size - index);
            this.obj[index] = object;
            size++;

        }

    }
    /**
     * <p>Метод для удаления объекта по индексу</p>
     * @param index индекс необходимого объекта
     * @throws OutIndexException В случае невалидного индекса
     */
    public void remove(int index) throws OutIndexException {

        if (index < size && index >= 0) {
            System.arraycopy(obj, index + 1, obj, index, size - index - 1);
            size--;
        } else {
            throw new OutIndexException();
        }

    }
    /**
     * <p>Метод для расширения вместимости коллекции</p>
     */
    private void enlargement() {
        capatity = (size * 3 / 2 + 1);
        T[] objInstance = (T[]) new Object[capatity];
        if (size >= 0)
            System.arraycopy(obj, 0, objInstance, 0, size);
        this.obj = (T[]) objInstance;

    }
    /**
     * <p>Метод для получения части коллекции</p>
     * @param startIndex индекс начала части коллекции
     * @param lastIndex индекс конца части коллекции
     * @throws OutIndexException В случае невалидного индекса
     * @return Возвращает подколлекцию
     */
    public Object[] subList(int startIndex, int lastIndex) throws OutIndexException {
        if (startIndex >= 0 && startIndex < lastIndex && lastIndex < size) {
            Object[] list = new Object[lastIndex - startIndex];
            for (int i = startIndex, j = 0; i < lastIndex; i++, j++)
                list[j] = this.obj[i];
            return list;
        } else throw new OutIndexException();
    }
    /**
     * <p>Метод для сериализации коллекции в строку</p>
     * @return Возвращает строку содержащую объекты коллекции
     */
    public String toString() {
        String str = "[";
        for (int i = 0; i < size; i++)
            str += (obj[i].toString() + " ");
        str += "]";
        return str;
    }


}

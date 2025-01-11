import java.lang.Exception;

public class MyArrayList<T> {
    private int capatity = 10;
    private int size=0;
    private T[] obj;

    public MyArrayList() {
        obj = (T[]) new Object[capatity];
        //size = 0;
    }
    public T get(int index){return (T) obj[index];}
    public void set(int index,T object)throws Exception{
        if (index > size||index<0)
            throw new OutIndexException();
        else obj[index-1]=object;
    }
    public int size(){return size;}
    public void add(T object){
        obj[size++]=object;
    }
    public void add(int index, T object) throws Exception {
        if (index > size||index<=0)
            throw new OutIndexException();
        else {
            if (size == capatity) {
                enlargement();
            }
            //for (int i = index; i < size; i++)
                //this.obj[i + 1] = this.obj[i];

                System.arraycopy(obj,index,obj,index+1,size-index);
            this.obj[index] = object;
            size++;

           // size++;
        }

    }

    public void remove(int index) throws Exception {

        if (index < size && index >= 0) {
//            for (int i = index; i < size - 1; i++)
                System.arraycopy(obj,index+1,obj,index,size-index-1);
//                this.obj[i] = this.obj[i + 1];
            size--;
        } else {
            throw new OutIndexException();
        }

    }

    private void enlargement() {
        capatity = (size * 3 / 2 + 1);
        T[] objInstance = (T[])new Object[capatity];
        if (size >= 0)
            System.arraycopy(obj, 0, objInstance, 0, size);
        this.obj = (T[]) objInstance;

    }

    public Object[] subList(int startIndex, int lastIndex) throws Exception {
        if (startIndex >= 0 && startIndex < lastIndex && lastIndex < size) {
            Object[] list = new Object[lastIndex - startIndex];
            for (int i = startIndex, j = 0; i < lastIndex; i++, j++)
                list[j] = this.obj[i];
            return list;
        }else throw new OutIndexException();
    }
    public String toString(){
        String str="[";
        for(int i=0;i<size;i++)
            str+=(obj[i].toString()+" ");
        str+="]";
        return str;
    }


}

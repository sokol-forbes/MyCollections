import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int number, index = 0, count;
        MyArrayList<Integer> list = new MyArrayList<>();
        System.out.println(list.size() + "\n" + "Введите количество чисел");
        Scanner in = new Scanner(System.in);
        count = in.nextInt();
        for (int i = 1; i <= count; i++) {
            try {
                System.out.println("Введите "+i +" число");
                number=in.nextInt();
                list.add(number);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println(list);
        System.out.println("Введите номер под которым хотите записать число");
        index=in.nextInt();
        System.out.println("Введите число");
        number=in.nextInt();
        try {
            list.add(index-1,number);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(list);
        System.out.println("Введите номер числа который хотите изменить");
        index=in.nextInt();
        System.out.println("Введите число");
        number=in.nextInt();

        try {
            list.set(index,number);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(list);
        // System.out.println("Последний элемент "+list.get(list.size()-1));

    }
//public static void main(String[] args) {
//    MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
//    myLinkedList.add(1);
//    myLinkedList.add(2);
//    myLinkedList.add(3);
//    myLinkedList.add(4);
//    myLinkedList.add(5);
//    System.out.println(myLinkedList.toString());
//    System.out.println(myLinkedList.subList(1,3).toString());
//    try {
//        myLinkedList.remove(1);
//    } catch (OutIndexException e) {
//        System.out.println(e.getMessage());
//    }
//    System.out.println(myLinkedList.toString());
//}
}
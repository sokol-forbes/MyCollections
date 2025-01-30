import Patterns.FactoryMethod.Logistic;
import Patterns.Flyweight.Forest;
import Patterns.Strategy.Order;
import Patterns.Strategy.PayByCreditCard;
import Patterns.Strategy.PayByQuvi;
import Patterns.Strategy.PayStrategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static int TREES_TO_DRAW = 100;
    static int TREE_TYPES = 2;
    static int CANVAS_SIZE = 500;
    private static Map<Integer, Integer> priceOnProducts = new HashMap<>();
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Order order = new Order();
    private static PayStrategy strategy;

    static {
        priceOnProducts.put(1, 2200);
        priceOnProducts.put(2, 1850);
        priceOnProducts.put(3, 1100);
        priceOnProducts.put(4, 890);
    }
    public static void main(String[] args) throws IOException {

        Logistic logistic = new Logistic("Морская соль","Вода");
        logistic.getTransport().deliver();
        Logistic logistic2 = new Logistic("Настольная игра","Земля");
        logistic2.getTransport().deliver();


        Forest forest = new Forest();
        for(int i=0; i < Math.floor(TREES_TO_DRAW / TREE_TYPES); i++){
            forest.plantTree(random(0,CANVAS_SIZE),random(0,CANVAS_SIZE),"Eлка","еловый","");
            forest.plantTree(random(0,CANVAS_SIZE),random(0,CANVAS_SIZE),"Береза","чернобелый ","с зеленой кроной");
        }
        forest.draw();
        StrategyDemo();


}
    private static int random(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }
    private static void StrategyDemo() throws IOException {


            priceOnProducts.put(1, 2200);
            priceOnProducts.put(2, 1850);
            priceOnProducts.put(3, 1100);
            priceOnProducts.put(4, 890);
        while (!order.isClosed()) {
            int cost;

            String continueChoice;
            do {
                System.out.print("Выберите продукт:" + "\n" +
                        "1 - Материнская плата" + "\n" +
                        "2 - Процессор" + "\n"
                        );
                int choice = Integer.parseInt(reader.readLine());
                cost = priceOnProducts.get(choice);
                System.out.print("Количество: ");
                int count = Integer.parseInt(reader.readLine());
                order.setTotalCost(cost * count);
                System.out.print("Желаете продолжить выбор? Да/Нет: ");
                continueChoice = reader.readLine();
            } while (continueChoice.equalsIgnoreCase("Да"));

            if (strategy == null) {
                System.out.println("Выберите метод оплаты:" + "\n" +
                        "1 - Киви" + "\n" +
                        "2 - Кредитная карта");
                String paymentMethod = reader.readLine();

                // Клиент создаёт различные стратегии на основании
                // пользовательских данных, конфигурации и прочих параметров.
                if (paymentMethod.equals("1")) {
                    strategy = new PayByQuvi();
                } else {
                    strategy = new PayByCreditCard();
                }

    }
}}}
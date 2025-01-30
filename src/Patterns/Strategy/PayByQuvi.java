package Patterns.Strategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class PayByQuvi implements PayStrategy{
    private static final Map<String, String> DATA_BASE = new HashMap<>();
    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private String login;
    private String password;
    private boolean signedIn;
    @Override
    public boolean pay(int paymentAmount) {
        if (signedIn) {
            System.out.println("Оплата " + paymentAmount + " через Киви");
            return true;
        } else {
            return false;
        }
    }
    private boolean verify() {
        setSignedIn(login.equals(DATA_BASE.get(password)));
        return signedIn;
    }
    @Override
    public void collectPaymentDetails() {
        try {
            while (!signedIn) {
                System.out.print("Введите логин");
                login = READER.readLine();
                System.out.print("Введите пароль ");
                password = READER.readLine();
                if (verify()) {
                    System.out.println("Успешно");
                } else {
                    System.out.println("Попробуй еще раз");
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    private void setSignedIn(boolean signedIn) {
        this.signedIn = signedIn;
    }
}

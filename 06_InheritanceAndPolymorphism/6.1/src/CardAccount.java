import java.util.Scanner;

public class CardAccount extends PaymentAccount {
    public CardAccount(int cash) {
        super(cash);
        this.FINE = 1.01;
    }
    Scanner scanner = new Scanner(System.in);
    @Override
    public void removeCash(double cash) {
        System.out.println("При снятии со счета взымается комиссия 1%. Вы согласны с условиями? (Да/Нет)");
        String word = scanner.nextLine();
        if (word.toUpperCase().equals("ДА")) {
            super.removeCash(cash);
        }
        else
            System.out.println("Вы отказались от снятия наличных");
    }
}

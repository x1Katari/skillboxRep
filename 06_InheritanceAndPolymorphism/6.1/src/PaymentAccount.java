public class PaymentAccount {
    protected long balance;
    protected double FINE = 1;

    public PaymentAccount (int cash) {
        if (cash >= 0)
            this.balance += cash; //Начальный баланс
        else
            System.out.println("Начальный баланс не может быть отрицательным");
    }

    public long getBalance() {
        return balance;
    }
    public void addCash(int cash) {
        this.balance += cash;
    }
    public void removeCash(double cash) {
        if (this.balance >= cash * FINE) {
            this.balance -= cash * FINE;
            System.out.println("Спасибо, что остаетесь с нами.");
        }
        else
            System.out.println("Недостаточно средств, для снятия денег.");
    }
}

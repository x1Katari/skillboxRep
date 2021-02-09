public abstract class Client {
    private String num;
    private int balance;
    protected double FINE_ONE = 1;
    protected double FINE_TWO = 1;
    protected double FINE = 1;

    public Client (double cash) {
        if (cash >= 0)
            this.balance += cash * 1000; //Начальный баланс
        else
            System.out.println("Начальный баланс не может быть отрицательным");
        long i = (long) (1000000000000000L + Math.random() * 10000000000000000L);
        this.num = String.format("%16d", i);
    }
    protected void addCash(double cash) {
        int amount = (int) (cash * 1000) - getDepositCommission(cash);
        if (cash < 1000)
            this.balance += amount;
        else
            this.balance += amount;
    }
    protected void removeCash(double cash) {
        int amount = (int) (cash * 1000) + getWithdrawalCommission(cash);
        if (this.balance >= amount) {
            this.balance -= amount;
            System.out.println("Спасибо, что остаетесь с нами.");
        }
        else
            System.out.println("Недостаточно средств, для снятия денег.");
    }
    protected double getBalance() { return (double) balance / 1000; }
    protected String getNum() { return num; }
    protected abstract int getWithdrawalCommission(double cash);
    protected abstract int getDepositCommission(double cash);
}

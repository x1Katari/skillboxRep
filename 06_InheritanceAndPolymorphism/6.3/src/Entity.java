public class Entity extends Client {
    public Entity (double cash) {
        super(cash);
        this.FINE = 0.01;
    }

    @Override
    protected int getWithdrawalCommission(double cash) {
        int commission = (int) (cash * 1000 * FINE);
        System.out.println("Комиссия составит " + (double) commission / 1000 + " рублей");
        return commission;
    }

    @Override
    protected int getDepositCommission(double cash) { return 0; }

}

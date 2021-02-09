public class Individual extends Client {
    public Individual (double cash) {
        super(cash);
    }

    @Override
    protected int getWithdrawalCommission(double cash) { return 0; }

    @Override
    protected int getDepositCommission(double cash) { return 0; }
}
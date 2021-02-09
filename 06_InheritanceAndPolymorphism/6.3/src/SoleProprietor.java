public class SoleProprietor extends Client {
    public SoleProprietor(double cash) {
        super(cash);
        this.FINE_ONE = 0.01;
        this.FINE_TWO = 0.005;
    }

    @Override
    protected int getWithdrawalCommission(double cash) { return 0; }

    @Override
    protected int getDepositCommission(double cash) {
        if (cash < 1000) {
            int commission = (int) (cash * 1000 * FINE_ONE);
            System.out.println("Комиссия составит " + (double) commission / 1000 + " рублей");
            return commission;
        }
        else {
            int commission = (int) (cash * 1000 * FINE_TWO);
            System.out.println("Комиссия составит " + (double) commission / 1000 + " рублей");
            return commission;
        }
    }
}

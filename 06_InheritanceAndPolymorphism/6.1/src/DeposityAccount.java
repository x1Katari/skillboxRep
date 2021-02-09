import java.time.LocalDate;

public class DeposityAccount extends PaymentAccount {
    private LocalDate start;

    public DeposityAccount(int cash) {
        super(cash);
    }

    @Override
    public void addCash(int cash) {
        super.addCash(cash);
        this.start = LocalDate.now().plusMonths(1);;
    }

    @Override
    public void removeCash(double cash) {
        if (LocalDate.now().compareTo(start) >= 0)
            super.removeCash(cash);
        else
            System.out.println("С момента пополнения счета не прошло 30ти дний.");
    }


}

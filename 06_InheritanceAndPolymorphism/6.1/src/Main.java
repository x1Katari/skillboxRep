public class Main {
    public static void main(String[] args) {
        DeposityAccount account = new DeposityAccount(100);
        System.out.println(account.getBalance());
        account.removeCash(50);
        System.out.println(account.getBalance());
        account.addCash(25);
        System.out.println(account.getBalance());
        account.removeCash(10);
        System.out.println(account.getBalance());
        System.out.println("\n====================================\n");
        CardAccount account1 = new CardAccount(230);
        System.out.println(account1.getBalance());
        account1.addCash(100);
        System.out.println(account1.getBalance());
        account1.removeCash(50);
        System.out.println(account1.getBalance());
    }
}

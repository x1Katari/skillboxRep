public class Main {
    public static void main(String[] args) {

        Client a = new Individual(150);
        System.out.println(a.getNum());
        a.addCash(250);
        System.out.println(a.getBalance());
        a.removeCash(200);
        System.out.println(a.getBalance());
        System.out.println("\n===================================\n");

        Client b = new Entity(150);
        System.out.println(b.getNum());
        b.addCash(250);
        System.out.println(b.getBalance());
        b.removeCash(200);
        System.out.println(b.getBalance());
        System.out.println("\n===================================\n");

        Client c = new SoleProprietor(150);
        System.out.println(c.getNum());
        c.addCash(250);
        System.out.println(c.getBalance());
        c.removeCash(200);
        System.out.println(c.getBalance());

    }
}

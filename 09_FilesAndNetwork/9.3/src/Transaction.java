public class Transaction {

    private String description = ""; //описание расхода
    private double transfer = 0; //денежный поток
    private boolean type = true; //false - расход, true - доход

    public Transaction (String description, double income, double expense) {
        if (income != 0)
            this.transfer = income;
        else {
            this.description = description.replaceAll("[^A-z]", " ").replaceAll("\\\\"," ").replaceAll("\\s+"," "). trim();
            this.transfer = expense;
            type = false;
        }
    }
    public String getDescription() {
        return description;
    }
    public double getTransfer() {
        return transfer;
    }
    public boolean getType() {
        return type;
    }
    public String toString()
    {
        return description + "  -  " + transfer + " руб.";
    }
}

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main
{
    private static String statementFile = "data/movementList.csv";
    public static void main(String[] args) {
        ArrayList<Transaction> statement = loadStatementFromFile();
        double income = 0;
        double expense = 0;
        for (Transaction transaction : statement) {
            if (transaction.getType() == true)
                income += transaction.getTransfer();
            else expense += transaction.getTransfer();
        }
        System.out.println("Сумма расходов: " + expense + " руб.");
        System.out.println("Сумма доходов: " + income + " руб.\n");
        for (Transaction transaction : statement) {
            if (transaction.getType() == false)
                System.out.println(transaction);
        }
    }

    private static ArrayList<Transaction> loadStatementFromFile() {
        ArrayList<Transaction> statement = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(statementFile));
            for(int i = 1; i < lines.size(); i++)
            {
                if (!lines.get(i).contains("\"")) {
                    String[] columns = lines.get(i).split(",");
                    if (columns.length != 8) {
                        System.out.println("Wrong line: " + lines.get(i));
                        continue;
                    }
                    statement.add(new Transaction(columns[5], Double.parseDouble(columns[6]), Double.parseDouble(columns[7])));
                }
                else {
                    String[] subColumns = lines.get(i).split("\"");
                    if (subColumns.length == 2) {
                        subColumns[1] = subColumns[1].replace(",",".");
                        lines.set(i, subColumns[0] + subColumns[1]);
                    }
                    if (subColumns.length == 3) {
                        subColumns[2] = subColumns[2].replace(",",".");
                        lines.set(i, subColumns[0] + subColumns[1] + subColumns[2]);
                    }
                    String[] columns = lines.get(i).split(",");
                    if (columns.length != 8) {
                        System.out.println("Wrong line: " + lines.get(i));
                        continue;
                    }
                    statement.add(new Transaction(columns[5], Double.parseDouble(columns[6]), Double.parseDouble(columns[7])));
                }
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return statement;
    }
}

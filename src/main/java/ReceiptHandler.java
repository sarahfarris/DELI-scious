import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Handles the storage and retrieval of receipt.
 */
public class ReceiptHandler {
    private static final String path = "src/main/resources/receipt/";

    public static void saveOrderReceipt(ArrayList<MenuItem> orderItems, double total) throws IOException {
        // Use the current date and time to make the file name unique
        LocalDateTime now = LocalDateTime.now();
        String fileName = now.format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));

        // Write the receipt to the file
        try (PrintStream printStream = new PrintStream(new FileOutputStream(path + fileName))) {
            printStream.println("----------------------- Order Receipt ----------------------- ");
            printStream.println("Date: " + now.format(DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss")));

            for (MenuItem m : orderItems) {
                printStream.println(m.itemDescription);
            }
            printStream.println();
            printStream.printf("TOTAL: $%.2f%n", total);
        }
       System.out.println("Receipt " + fileName + " successfully stored in the vault.");
    }

    public static void getReceiptFromVault(String receiptId) throws IOException {
        String fullPath = path + receiptId;

        try (var reader = new Scanner(new File(fullPath))) {
            System.out.println("------ Receipt: " + receiptId + "----");
            while (reader.hasNextLine()) {
                System.out.println(reader.nextLine());
            }
        } catch (IOException e) {
            throw new IOException("Couldn't find the receipt with id " + receiptId);
        }
    }
}

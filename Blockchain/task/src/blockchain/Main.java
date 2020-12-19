package blockchain;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        String filename = "Blockchain.data";
        // Scanner scanner = new Scanner(System.in);
        // System.out.println("Enter how many zeros the hash must start with: ");
        // int numberOfZeros = scanner.nextInt();

        try {
            Blockchain blockchain = new Blockchain(5, filename);
            for (int i = blockchain.getSize() - 5; i < blockchain.getSize(); i++) {
                System.out.println(blockchain.getBlockAt(i) + "\n");
            }
        } catch (RuntimeException | IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
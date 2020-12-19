package blockchain;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        String filename = "Blockchain.data";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter how many zeros the hash must start with: ");
        int numberOfZeros = scanner.nextInt();

        try {
            Blockchain blockchain = new Blockchain(5, getHashPrefix(numberOfZeros), filename);
            for (int i = blockchain.getSize() - 5; i < blockchain.getSize(); i++) {
                System.out.println(blockchain.getBlockAt(i) + "\n");
            }
        } catch (RuntimeException | IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static String getHashPrefix(int n) {
        StringBuilder zeros = new StringBuilder();
        for (int i = 0; i < n; i++) {
            zeros.append("0");
        }
        return zeros.toString();
    }
}

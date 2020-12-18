package blockchain;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.time.LocalTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter how many zeros the hash must start with: ");
        int numberOfZeros = scanner.nextInt();

        List<Block> blocks = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Block block = new Block();
            block.setId(i + 1);
            block.setTimestamp(generateTimestamp());
            block.setPreviousHash(i != 0 ? blocks.get(i - 1).getHash() : "0");
            block.setMagicNumber(generateMagicNumber(zerosString(numberOfZeros)));
            LocalTime localTimeStart = LocalTime.now();
            block.setHash(applySha256(block.getMagicNumber()));
            LocalTime localTimeStop = LocalTime.now();
            block.setSeconds(localTimeStop.getSecond() - localTimeStart.getSecond());
            blocks.add(block);
        }

        if (isValid(blocks)) {
            for (int i = 0; i < blocks.size(); i++) {
                System.out.println("\nBlock:");
                System.out.println("Id: " + blocks.get(i).getId());
                System.out.println("Timestamp: " + blocks.get(i).getTimestamp());
                System.out.println("Magic number: " + blocks.get(i).getMagicNumber());
                System.out.println("Hash of the previous block:");
                System.out.println(blocks.get(i).getPreviousHash());
                System.out.println("Hash of the block:\n" + blocks.get(i).getHash());
                System.out.printf("Block was generating for %d seconds\n", blocks.get(i).getSeconds());
            }
        }
    }

    public static boolean isValid(List<Block> blocks) {
        if (blocks.size() <= 1) {
            return blocks.isEmpty() || "0".equals(blocks.get(0).getPreviousHash());
        }
        for (int i = 1; i < blocks.size(); i++) {
            boolean valid = blocks.get(i).getPreviousHash().equals(blocks.get(i - 1).getHash());
            if (!valid) {
                return false;
            }
        }
        return true;
    }

    public static String generateTimestamp() {
        long timeStamp = new Date().getTime();
        return timeStamp + "";
    }

    /* Applies Sha256 to a string and returns a hash. */
    public static String applySha256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            /* Applies sha256 to our input */
            byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (byte elem : hash) {
                String hex = Integer.toHexString(0xff & elem);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String generateMagicNumber(String zeros) {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            stringBuilder.append(random.nextInt(9) + "");
        }
        String magicNumber = stringBuilder.toString();
        String hash = applySha256(magicNumber);

        if (!hash.startsWith(zeros)) {
            return generateMagicNumber(zeros);
        }
        return magicNumber;

    }

    public static String zerosString(int n) {
        StringBuilder zeros = new StringBuilder();
        for (int i = 0; i < n; i++) {
            zeros.append("0");
        }
        return zeros.toString();
    }
}

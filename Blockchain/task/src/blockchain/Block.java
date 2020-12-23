package blockchain;

import java.io.Serializable;
import java.util.*;

public class Block implements Serializable {

    private static final long serialVersionUID = 1L;

    static final Random random = new Random();
    static long idCounter = 0;

    static int numberOfZeros = 0;

    private String threadName;
    private Long id;
    private Long timestamp;
    private String previousHash;
    private Integer magicNumber;
    private String hash;
    private String message;
    private long milliseconds;
    private String modificationOfN;


    public Block(String previousHash) {
        this.id = idCounter++;
        //this.timestamp = new Date().getTime();
        this.timestamp = System.currentTimeMillis();
        this.previousHash = previousHash;
        this.magicNumber = random.nextInt(10000000);
        this.hash = StringUtil.applySha256(id.toString() + timestamp.toString()
                + previousHash + magicNumber.toString());
        do {
            this.magicNumber = random.nextInt(10000000);
            this.hash = StringUtil.applySha256(id.toString() + timestamp.toString()
                    + previousHash + magicNumber.toString());
        } while (!hash.startsWith(getHashPrefix(numberOfZeros)));

        this.message = "no message\n";

        this.milliseconds = System.currentTimeMillis() - timestamp;

        if (milliseconds < 15000) {
            numberOfZeros++;
            modificationOfN = "N was increased to " + numberOfZeros;
        } else if (milliseconds > 100000) {
            numberOfZeros--;
        } else {
            modificationOfN = "N stays the same";
        }
    }

    public static void setIdCounter(long idCounter) {
        Block.idCounter = idCounter;
    }

    public static String getHashPrefix(int n) {
        StringBuilder zeros = new StringBuilder();
        for (int i = 0; i < n; i++) {
            zeros.append("0");
        }
        return zeros.toString();
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public static int getNumberOfZeros() {
        return numberOfZeros;
    }

    public static void setNumberOfZeros(int numberOfZeros) {
        Block.numberOfZeros = numberOfZeros;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public Integer getMagicNumber() {
        return magicNumber;
    }

    public void setMagicNumber(Integer magicNumber) {
        this.magicNumber = magicNumber;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }


    public void setMessage(List<Message> messages) {
        if (messages.size() == 0) {
            this.message = "no messages\n";
        } else {
            this.message = "";
            for (int i = 0; i < messages.size() - 1; i++) {
                this.message += messages.get(i).getUser()  + " : " + messages.get(i).getMessage() + "\n";
            }
        }
    }

    @Override
    public String toString() {
        return "Block:\n" +
                "Created by miner # " + threadName +
                "\nId: " + id +
                "\nTimestamp: " + timestamp +
                "\nMagic number: " + this.magicNumber +
                "\nHash of the previous block:\n" + previousHash +
                "\nHash of the block:\n" + hash +
                "\nBlock data:\n" + message +
                "Block was generating for " + milliseconds / 1000 + " seconds" +
                "\n" + modificationOfN;
    }

}
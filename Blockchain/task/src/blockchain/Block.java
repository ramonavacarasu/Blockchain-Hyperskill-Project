package blockchain;

import java.io.Serializable;
import java.util.Date;
import java.util.Random;

public class Block implements Serializable {

    static final Random random = new Random();
    static long idCounter = 0;

    private Long id;
    private Long timestamp;
    private String previousHash;
    private Integer magicNumber;
    private String hash;
    private long seconds;

    public Block(String previousHash, String hashPrefix) {
        this.id = idCounter++;
        this.timestamp = new Date().getTime();
        this.previousHash = previousHash;
        this.magicNumber = random.nextInt(10000000);
        this.hash = StringUtil.applySha256(id.toString() + timestamp.toString()
            + previousHash + magicNumber.toString());

        do {
            this.magicNumber = random.nextInt(10000000);
            this.hash = StringUtil.applySha256(id.toString() + timestamp.toString()
                    + previousHash + magicNumber.toString());
        } while (!hash.startsWith(hashPrefix));
        this.seconds = new Date().getTime() - timestamp;
    }

    public static void setIdCounter(long idCounter) {
        Block.idCounter = idCounter;
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

    public long getSeconds() {
        return seconds;
    }

    public void setSeconds(long seconds) {
        this.seconds = seconds;
    }

    @Override
    public String toString() {
        return "Block:\n" +
                "Id: " + id +
                "\nTimestamp: " + timestamp +
                "\nMagic number: " + this.magicNumber +
                "\nHash of the previous block:\n" + previousHash +
                "\nHash of the block:\n" + hash +
                "\nBlock was generating for " + seconds;
    }

}

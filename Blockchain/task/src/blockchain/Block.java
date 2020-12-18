package blockchain;

public class Block {

    private long id;
    private String timestamp;
    private String previousHash;
    private String magicNumber;
    private String hash;
    private long seconds;

    public Block() {
    }

    public Block(long id, String timestamp, String previousHash,
                 String magicNumber, String hash, long seconds) {
        this.id = id;
        this.timestamp = timestamp;
        this.previousHash = previousHash;
        this.magicNumber = magicNumber;
        this.hash = hash;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public String getMagicNumber() {
        return magicNumber;
    }

    public void setMagicNumber(String magicNumber) {
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
}

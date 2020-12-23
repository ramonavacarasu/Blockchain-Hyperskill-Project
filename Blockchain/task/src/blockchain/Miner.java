package blockchain;

import java.util.List;
import java.util.concurrent.Callable;

public class Miner implements Callable<Block> {

    private String prevHash;
    private List<Message> messages;

    public Miner(String prevHash, List<Message> messages) {
        this.prevHash = prevHash;
        this.messages = messages;
    }

    @Override
    public Block call() {
        Block block = new Block(prevHash);
        block.setThreadName(Thread.currentThread().getName());
        if (!prevHash.equals("0")) {
            block.setMessage(messages);
        }
        return block;
    }
}

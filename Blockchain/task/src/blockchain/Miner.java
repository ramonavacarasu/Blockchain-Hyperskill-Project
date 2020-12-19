package blockchain;

import java.util.concurrent.Callable;

public class Miner implements Callable<Block> {

    private String prevHash;

    public Miner(String prevHash) {
        this.prevHash = prevHash;
    }

    @Override
    public Block call() {
        Block block = new Block(prevHash);
        block.setThreadName(Thread.currentThread().getName());
        return block;
    }
}

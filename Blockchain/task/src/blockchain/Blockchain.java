package blockchain;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Blockchain implements Serializable {

    private static final long serialVersionUID = 1L;

    private ArrayList<Block> blockchain;
    private String hashPrefix;

    public Blockchain(int numberOfBlocks, String hashPrefix, String filename)
            throws IOException, ClassNotFoundException {

        File file = new File(filename);
        if (file.exists() && file.isFile()) {
            this.blockchain = (ArrayList<Block>) SerializationUtils.deserialize(filename);
            Block.setIdCounter(this.blockchain.get(this.blockchain.size() - 1).getId() + 1);
            if (!this.isValid(blockchain)) {
                throw new RuntimeException("Invalid Blockchain");
            }
        } else {
            this.blockchain = new ArrayList<>();
        }

        this.hashPrefix = hashPrefix;

        if (numberOfBlocks > 0 && this.blockchain.size() == 0) {
            Block block = new Block("0", this.hashPrefix);
            this.blockchain.add(block);
            SerializationUtils.serialize(this.blockchain, filename);
        }

        int blockChainSize = this.blockchain.size();

        for (int i = blockChainSize; i < blockChainSize + numberOfBlocks; i++) {
            Block block = new Block(this.blockchain.get(i - 1).getHash(), this.hashPrefix);
            this.blockchain.add(block);
            SerializationUtils.serialize(this.blockchain, filename);
        }
    }

    public boolean isValid(List<Block> blocks) {
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

    public int getSize() {
        return this.blockchain.size();
    }

    public Block getBlockAt(int blockId) throws IndexOutOfBoundsException {
        try {
            return this.blockchain.get(blockId);
        } catch (RuntimeException e) {
            throw new ArrayIndexOutOfBoundsException(e.getMessage());
        }
    }

    @Override
    public String toString() {
        String blockchainString = "";
        for (Block block : blockchain) {
            blockchainString += block.toString() + "\n\n";
        }
        return blockchainString;
    }
}

package blockchain;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        String filename = "Blockchain.data";
        int nThreads = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(nThreads);

        Blockchain blockchain = new Blockchain(filename);
        MessageSender[] messageSenders = new MessageSender[4];

        for (int i = 0; i < 4; i++) {
            messageSenders[i] = new MessageSender(MessageSender.getRandomName(), blockchain);
            executor.submit(messageSenders[i]);
        }

        blockchain.generateBlocks(5, filename, executor);

        for (int i = blockchain.getSize() - 5; i < blockchain.getSize(); i++) {
            System.out.println(blockchain.getBlockAt(i) + "\n");
        }

        do {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (blockchain.getSize() < 5);

        for (MessageSender messageSender : messageSenders) {
            messageSender.interrupt();
        }

        executor.shutdown();
    }
}
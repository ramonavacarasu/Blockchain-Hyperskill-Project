package blockchain;

import java.util.Random;

public class MessageSender extends Thread {

    public final static String[] subjects = new String[]{"Peter ", "Lois ", "Chris ", "Meg ", "Brian ", "Joe ", "Bonnie "};
    private final static String[] actions = new String[]{"eats ", "cooks ", "buys "};
    private final static String[] objects = new String[]{"mushrooms.", "tomatoes.", "apples.", "hot dogs."};
    private final static Random r = new Random();

    private final String name;
    private  Blockchain blockchain;

    public MessageSender(String name, Blockchain blockchain) {
        this.name = name;
        this.blockchain = blockchain;
    }

    @Override
    public void run() {
        do {

            int i = r.nextInt(subjects.length);
            String subject = subjects[i];

            if (subject.trim().equals(name)) {
                subject = subjects[(i + 1) % subjects.length];
            }

            String msg = subject +
                    actions[r.nextInt(actions.length)] +
                    objects[r.nextInt(objects.length)];

            Message message = new Message(name, msg);
            blockchain.addMessage(message);

            try {
                Thread.sleep(r.nextInt(50));
            } catch (InterruptedException ignore) {
            }
        } while (!this.isInterrupted());

    }

    public static String getRandomName() {
        return subjects[r.nextInt(subjects.length)].trim();
    }
}

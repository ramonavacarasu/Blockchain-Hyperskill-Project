import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        Map<Integer, Integer> nodes = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int parent = scanner.nextInt();
            int child = scanner.nextInt();
            nodes.put(child, parent);
        }

        boolean isBinary = true;

        for (int value : nodes.values()) {
            int arePairs = 0;
            for (int key : nodes.keySet()) {
                if (nodes.get(key) == value) {
                    arePairs++;
                }
            }
            if (arePairs != 2) {
                isBinary = false;
                break;
            }
        }

        System.out.println(isBinary ? "yes" : "no");

    }
}
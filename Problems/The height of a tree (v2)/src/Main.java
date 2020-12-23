import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int len = Integer.parseInt(scanner.nextLine());

        int[] nodes = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();


        int depth = 0;
        for (int i = 0; i < len; i++) {
            int currentDepth = 1;
            int index = i;
            while (scanner.nextInt() != -1) {
                currentDepth++;
               // index = nodes[index];
            }
             depth = Math.max(currentDepth, depth);
        }
        System.out.println(depth);
    }
}
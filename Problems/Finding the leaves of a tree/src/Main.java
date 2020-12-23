import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int len = Integer.parseInt(scanner.nextLine());

        List<Integer> childs = new ArrayList<>();
        List<Integer> parents = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            parents.add(scanner.nextInt());
            childs.add(scanner.nextInt());
        }

        childs.removeAll(parents);

        System.out.println(childs.size());

        for (int i : childs) {
            System.out.print(i + " ");
        }

    }
}
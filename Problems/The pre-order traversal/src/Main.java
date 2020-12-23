import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int depth = Integer.parseInt(scanner.nextLine());
        print(0, 0, depth);
    }

    public static void print(int node, int currentLevel, int depth) {
        if (currentLevel <= depth) {
            System.out.print(node + " ");
            for (int i = 1; i < 4; i++) {
                print(node * 3 + i, currentLevel + 1, depth);
            }
        }
    }
}
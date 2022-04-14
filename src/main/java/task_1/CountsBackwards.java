package task_1;

public class CountsBackwards {
    public static void main(String[] args) {
        int i = 100;
        while (i > 0) {
            if (i % 5 == 0 & i % 3 != 0) {
                System.out.println("Agile");
            } else if (i % 3 == 0 & i % 5 != 0) {
                System.out.println("Software");
            } else if (i % 3 == 0 & i % 5 == 0)
                System.out.println("Testing");
            else System.out.println(i);
            i--;
        }
    }
}

import java.util.ArrayList;
import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Long> fib = new ArrayList<>();
        fib.add(0l);
        fib.add(1l);
        long v1 = fib.get(fib.size() - 2);
        long v2 = fib.get(fib.size() - 1);

        for(int i = 0; i < 60; i++){
            fib.add(v1 + v2);
            v1 = fib.get(fib.size() - 2);
            v2 = fib.get(fib.size() - 1);
        }
        int howManyTestCases = in.nextInt();
        ArrayList<Integer> indexes = new ArrayList<>();
        for(int i = 0; i < howManyTestCases; i++){
            indexes.add(in.nextInt());
        }

        for(int index : indexes){
            System.out.println("Fib(" + index + ") = " + fib.get(index));
        }

    }
}

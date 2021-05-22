package week2;

import java.util.Scanner;

public class PerfectNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PerfectNumber perfectNumber = new PerfectNumber();
        int howMany = in.nextInt();
        for(int i = 0; i < howMany; i++){
            perfectNumber.check(in.nextDouble());
        }

    }

    private void check(double num){
        int counter = 0;

        for(int i = 1; i <= (num/2); i++){
            if(num % i == 0){
                counter += i;
            }
            if(counter > num){
                System.out.println((int)num + " nao eh perfeito");
                break;
            }
        }
        if(counter == num){
            System.out.println((int)num + " eh perfeito");
        }else if(counter < num){
            System.out.println((int)num + " nao eh perfeito"); }
    }
}

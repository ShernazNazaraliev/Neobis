package week2;

import java.util.Scanner;

public class ColumnInArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int col = in.nextInt();
        char operation = in.next().charAt(0);
        double sumCounter = 0;
        double arr [][] = new double[12][12];

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                arr[i][j] = in.nextDouble();
                if(j == col){
                    sumCounter += arr[i][j];
                }
            }
        }

        switch (operation){
            case 'S': System.out.println(String.format("%.1f", sumCounter));
                break;
            case 'M': System.out.println(String.format("%.1f", sumCounter/arr.length));
        }
    }
}


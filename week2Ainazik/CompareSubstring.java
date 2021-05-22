import java.util.Scanner;

public class CompareSubstring {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            count(in.nextLine(), in.nextLine());
        }

    }

    private static void count(String a, String b){
        int startIndex = 0;
        int stopIndex = 1;
        int counter = 0;

        for(int i = 0; i < a.length(); i++){
            String curr = a.substring(startIndex, stopIndex);
            if(b.contains(curr)){
                stopIndex++;
                counter = curr.length();
            } else {
                startIndex++;
                stopIndex++;
            }
        }
        System.out.println(counter);
    }
}



import java.util.Scanner;

public class Combiner {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        for(int i = 0; i < num; i++){
            combine(in.next(), in.next());
        }
    }
    private static void combine(String first, String second){
        StringBuilder sb = new StringBuilder();
        String tail;
        int shortest;
        if(first.length() == second.length()){
            shortest = first.length();
            tail = "";
        } else if(first.length() > second.length()){
            shortest = second.length();
            tail = first.substring(second.length(), first.length());
        }else {
            shortest = first.length();
            tail = second.substring(first.length(), second.length());
        }

        for(int i = 0; i < shortest; i++){
            sb.append(first.charAt(i));
            sb.append(second.charAt(i));
        }
        System.out.println(sb.append(tail));
    }
}

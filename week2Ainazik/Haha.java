import java.util.ArrayList;
import java.util.Scanner;

public class Haha {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        ArrayList<Character> chars = new ArrayList<>();

        for(int i = 0; i < s.length(); i++){
            char currChar = s.charAt(i);
            if(currChar == 'a' || currChar == 'e' || currChar == 'i'
                               || currChar == 'o' || currChar == 'u'){
                chars.add(currChar);
            }
        }

        boolean richtig = true;
        for(int i = 0, j = chars.size() - 1; i < j; i++, j--){
            if(chars.get(i) != chars.get(j)){
                richtig = false;
                break;
            }
        }
        System.out.println(richtig ? "S" : "N");
    }
}

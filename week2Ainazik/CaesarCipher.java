import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int c = 0;

        while (c <num){
            decrypt(in.next(), in.nextInt());
            c++;
        }
    }

    public static void  decrypt(String text, int key) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < text.length(); i++) {
            if((text.charAt(i) - key) >= 65){
                char ch = (char) (text.charAt(i) - key);
                result.append(ch);
            }else if((text.charAt(i) - key) < 65){
                char ch = (char) ((text.charAt(i) - key) + 26);
                result.append(ch);
            }
        }
        System.out.println(result);
    }
}
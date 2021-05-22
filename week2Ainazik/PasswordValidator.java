import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String s = in.nextLine();
            validate(s);
        }

    }
    private static void validate(String s){
        PasswordValidator pv = new PasswordValidator();
        pv.checkLen(s);
        if(pv.checkLen(s) && pv.checkTrash(s) && pv.checkReq(s)){
            System.out.println("Senha valida.");
        }else {
            System.out.println("Senha invalida.");
        }
    }

    private boolean checkLen(String s){
        if(s.length() >= 6 && s.length() <= 32){
            return true;
        }else{
            return false;
        }
    }

    private boolean checkTrash(String s){
        boolean valid = false;
        for (char c : s.toCharArray()){
            if(Character.isAlphabetic(c)){
                valid = true;
            } else if(Character.isDigit(c)){
                valid = true;
            }
            else {
                valid = false;
                break;
            }
        }
        return valid;
    }

    private boolean checkReq(String s){
        boolean b = false;
        int upperCaseCounter = 0;
        int lowerCaseCounter = 0;
        int digitCounter = 0;
        for(char ch : s.toCharArray()){
            if(Character.isUpperCase(ch)){
                upperCaseCounter++;
            }else if(Character.isLowerCase(ch)){
                lowerCaseCounter++;
            }else if(Character.isDigit(ch)){
                digitCounter++;
            }
        }
        if(upperCaseCounter >= 1 && lowerCaseCounter >= 1 && digitCounter >= 1){
            b = true;
        }
        return b;
    }
}

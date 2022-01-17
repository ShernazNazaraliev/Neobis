import java.util.Scanner;

public class Banknotes{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        double d = in.nextDouble ();
	int N = (int)d;
	double F = (d-N);
        System.out.println("NOTAS:");
        System.out.print((N/100)+ " nota(s) de R$ 100,00\n");
        N-=(N/100)*100;
        System.out.print((N/50)+ " nota(s) de R$ 50,00\n");
        N-=(N/50)*50;
        System.out.print((N/20)+ " nota(s) de R$ 20,00\n");
        N-=(N/20)*20;
        System.out.print((N/10)+ " nota(s) de R$ 10,00\n");
        N-=(N/10)*10;
        System.out.print((N/5)+ " nota(s) de R$ 5,00\n");
        N-=(N/5)*5;
        System.out.print((N/2)+ " nota(s) de R$ 2,00\n");
        N-=(N/2)*2;
	System.out.print((N)+ " nota(s) de R$ 1,00\n");
        in.close();
    }
}

import java.util.Scanner; 
public class PrimeNum {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		double howMany = in.nextInt();
		PrimeNum p = new PrimeNum();
		for(int j = 0; j < howMany; j++){
			p.check(in.nextDouble());
		}
		
	}
	
	private void check(double num){
		if(num <= 3){
			System.out.println((int)num + " eh primo");
		} else if(num > 3){
			boolean ft = true;
			double half = num / 2;
			for(double i = 2; i <= half; i++){
				if(num % i == 0){
					ft = false;
					System.out.println((int)num + " nao eh primo");
					break;
				}
			}
			if(ft == true){
				System.out.println((int)num + " eh primo");
			}
		}

	}
}
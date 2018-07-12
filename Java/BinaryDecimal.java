import java.util.Scanner;

public class BinaryDecimal {
	
	
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		System.out.println("CONVERSIONS");
		System.out.println("1: binary to decimal");
		System.out.println("2: decimal to binary");
		System.out.println("Enter key for your desired conversion: ");
		int key = scnr.nextInt();
		System.out.println();
		switch(key) {
		case 1: 
			System.out.print("Enter a binary number to convert to decimal: ");
			String num = scnr.next();
			for(int i=0; i<num.length(); i++) {
				if(num.charAt(i)!='0' && num.charAt(i)!='1') {
					System.out.print("The number you entered was not a binary number");
					System.exit(0);
				}
			}
			BinarytoDecimal(num);
			break;
		case 2:
			System.out.println("Enter a decimal number to convert to binary: ");
			int number = scnr.nextInt();
			DecimaltoBinary(number);
			break;
		}
		
	}
	
	
	
	public static int BinarytoDecimal(String num) {
		double result = 0;
		for(int i=0; i<num.length(); i++) {
			int lilnum = Character.getNumericValue(num.charAt(i));
			int x = (num.length()-1) - i;
			
			if(lilnum == 1) {
			result += Math.pow(2, x);
			}
		}
		int y = (int) result;
		System.out.print(y);
		return y;
	}
	

	public static String DecimaltoBinary(int num) {
		String k = Integer.toString(num, 2);
		System.out.print(k);
		return k;
	}
}
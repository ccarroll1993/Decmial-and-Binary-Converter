import java.util.regex.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Data_Visualization {
	public static Scanner scnr = new Scanner(System.in);

	public static void main(String[] args) {
		String point = "";
		boolean hello;
		int l = 2;
		ArrayList<String> str = new ArrayList<String>();
		ArrayList<Integer> nt = new ArrayList<Integer>();

		System.out.println("Enter a title for the data: ");
		String titleName = scnr.nextLine();
		System.out.println("You entered: " + titleName);

		System.out.println("Enter the column 1 header: ");
		String authorName = scnr.nextLine();
		System.out.println("You entered: " + authorName);

		System.out.println("Enter the column 2 header: ");
		String numOfNovels = scnr.nextLine();
		System.out.println("You entered: " + numOfNovels);
		System.out.println();
		
		System.out.println("The following data needs to be entered as such 'String, int' ");

		while (hello = true) {
			System.out.println("Enter a data point (-1 to stop input): ");
			point = scnr.nextLine();

			if (point.contains("-1")) {
				hello = false;
				break;
			}
			else if(CountingCommas(point) == 1 && point!="-1"){
				boolean test = false;
				for(int p = point.indexOf(", ") + 4; p < point.length(); p++){
					if(point.charAt(p) != '0' || point.charAt(p) != '1' || point.charAt(p) != '2' || point.charAt(p) != '3' || point.charAt(p) != '4' || point.charAt(p) != '5' || point.charAt(p) != '6' || point.charAt(p) != '7' || point.charAt(p) != '8' || point.charAt(p) != '9'){
						test = true;
					}
				}
				if(test == true){
					System.out.println("Error: Comma not followed by an integer.");
					System.out.println();
					continue;
				}
				else if(test == false){ 
					
					//String w = getWord(point);
					//int n = Integer.valueOf(getNum(point));
					
					System.out.print("Data string: ");
					String w = getWord(point);
					str.add(new String(w));

					System.out.print("Data integer: ");
					int n = Integer.valueOf(getNum(point));
					nt.add(new Integer(n));
					l = l + 1;
					System.out.println();
					continue;
				}
			}
			else if(CountingCommas(point) == 0 && point!="-1"){
				System.out.println("Error: No comma in string.");
				System.out.println();
				continue;
			}
			else if(CountingCommas(point) > 1 && point!="-1"){
				System.out.println("Error: Too many commas in input.");
				System.out.println();
				continue;
			}

		}
		System.out.printf("%25s\n", titleName);
		System.out.printf("%-20s | %23s\n", authorName, numOfNovels);
		System.out.print("----------------------------------------------\n");
		for (int k = 0; k<l-2; k++){
			System.out.printf("%-20s | %23s\n", str.get(k), nt.get(k));
		}
		System.out.println();
		
		for (int m = 0; m < l-2; m++){
			System.out.printf("%20s", str.get(m));
			System.out.print(" ");
			for (int p = 0; p < nt.get(m); p++){
				System.out.print("*");
			}
			System.out.println();
		}
		
	}

		


	public static String getWord(String phrase){
		String word = "";
		String nonnum = "[0-9,]";
		Matcher matcher = Pattern.compile(nonnum).matcher(phrase);
		if(matcher.find()){
			word = phrase.substring(0, matcher.start());
			System.out.println(phrase.substring(0, matcher.start()));	
		}
		return word;
	}

	public static String getNum(String phrase){
		String num = "";
		Matcher matcher = Pattern.compile("\\d+").matcher(phrase);
		if(matcher.find()){
			num = matcher.group();
			System.out.println(matcher.group());
		}
		return num;
	}

	public static int CountingCommas(String phrase){
		int counter = 0;
		int key = 0;
		for(key = 0; key < phrase.length(); key ++){
			if(phrase.charAt(key) == ','){
				counter = counter + 1;
			}
		}
		return counter;
	}
}
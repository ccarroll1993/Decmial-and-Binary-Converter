import java.util.Scanner;
public class Authorizing_Assistant
{
   public static Scanner scanner=new Scanner(System.in);
   public static void main(String[] args)
   {
     

       String text;
       System.out.println("Enter a sample text:");
       text=scanner.nextLine();

       System.out.println("You entered: " + text);

       char ch=printMenu();

       switch(ch) {
       case 'q':
           System.out.println("Exit the program");
           System.exit(0);
       case 'c':
           int cntNonWhitespaces=getNumOfNonWSCharacters(text);
           System.out.println("Number of non-whitespace characters: "+cntNonWhitespaces);
           break;
       case 'w':
           int wordsCount=getNumOfWords(text);
           System.out.println("Number of words: "+wordsCount);
           break;
       case 'f':
           System.out.println("Enter a word or phrase to be found: ");
           String find=scanner.nextLine();
           int findCount=findText(text,find);
           System.out.println("Number of words: "+findCount);
           break;
       case 'r':
           String newstring=replaceExclamation(text);
           System.out.println("Edited text: "+newstring);
           break;
       case 's':
           newstring=shortenSpace(text);
           System.out.println("Edited text: "+newstring);
           break;
       }

   }

   private static String shortenSpace(String text) {
       String temp = text.trim().replaceAll(" +", " ");
       return temp;
      
   }

   private static String replaceExclamation(String text) {

       String temp = text.replaceAll("!", ".");
       return temp;
   }


   private static int findText(String text, String find) {
       
       String[] words=text.split(" ");

       int count=0;
       for (int i = 0; i < words.length; i++) {
           if(words[i].equals(find))
               count++;
       }

       return count;
   }

   private static int getNumOfWords(String text) {

       String[] words=text.split(" ");

       return words.length;
   }


   private static int getNumOfNonWSCharacters(String text) {

       text=text.trim().replaceAll("\\s","");
       return text.length();          
   }

   private static char printMenu()
   {

       System.out.println("MENU");
       System.out.println("c - Number of non-whitespace characters.");
       System.out.println("w - Number of words.");
       System.out.println("f - Find text.");
       System.out.println("r - Replace all !'s.");
       System.out.println("s - Shorten spaces.");
       System.out.println("q - Quit.");

       System.out.println("Choose an option:");
       char choice=scanner.nextLine().charAt(0);

       return choice;
   }
}
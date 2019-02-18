package test_3;

import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        while(true){
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            input = input.replaceAll("[\\s]{2,}", " ");
            input = input.replaceAll(" ", "+");
            Translate.getTranslate(input);
        }



    }
}

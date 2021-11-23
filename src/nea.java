import java.io.IOException;
import java.util.Scanner;
//import java.util.Random;
public class nea
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        //[StartLogin]
        System.out.println("Enter Login player 1");
        player p1 = login(scanner);

        System.out.println("Login for player 2");
        player p2 = login(scanner);
        //[EndLogin]
        scanner.close();
    }
    static player login(Scanner scanner)
    {
        final int maxguesscount = 5;
        int guesscount = 0;
        // waiting for the guesscount to exceed the amount
        //login process
    
        System.out.println(guesscount + "/" + maxguesscount);    
        System.out.println("Enter your name");
        String p1name = scanner.nextLine();
        System.out.println("Enter your password");
        String p1password = scanner.nextLine();
        try 
        {
            if(loginclass.login(p1name, p1password))
            {
                System.out.println("The player has been returned");
                return new player(p1name);
            }
        } catch (IOException e) 
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

} 

